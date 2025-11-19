package com.neusoft.neu23.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
// 1. 引入必须的包
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dc")
@CrossOrigin
public class DemoController {

    /**
     * 2. 注入 KafkaTemplate，用于发送消息
     * 使用 @Autowired 进行字段注入
     */
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 使用构造器注入 ChatClient (保持你原有的逻辑不变)
     */
    private final ChatClient chatClient;

    public DemoController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    // ================== 新增 Kafka 测试接口 ==================

    /**
     * 3. 发送消息的接口
     * 浏览器访问：http://localhost:18080/dc/send?msg=你好Kafka
     */
    @GetMapping("/send")
    public String sendMsg(@RequestParam(value = "msg", defaultValue = "Hello Kafka") String msg) {
        // 发送消息到主题 "my-topic"
        kafkaTemplate.send("my-topic", msg);
        return "成功发送消息给 Kafka: " + msg;
    }

    /**
     * 4. 消息监听器
     * 自动接收 "my-topic" 主题的消息并打印到控制台
     */
    @KafkaListener(topics = "my-topic", groupId = "demo-group")
    public void listen(String message) {
        System.out.println("=================================");
        System.out.println("【消费者】收到 Kafka 消息: " + message);
        System.out.println("=================================");
    }

    // ================== 原有的 AI 聊天接口 (保持不变) ==================

    @GetMapping("/c4")
    public String chat4(@RequestParam(value = "msg", defaultValue = "你是谁") String msg,
                        @RequestParam(value = "chatId", defaultValue = "neu.edu.cn") String chatId) {
        return this.chatClient.prompt()
                .user(msg)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                .call()
                .content();
    }

    @GetMapping("/c3")
    public String chat3(@RequestParam(value = "msg", defaultValue = "你是谁") String msg,
                        @RequestParam(value = "chatId", defaultValue = "neu.edu.cn") String chatId) {
        return this.chatClient.prompt()
                .user(msg)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                .call()
                .content();
    }

    @GetMapping("/c2")
    public String chat2(@RequestParam(value = "msg", defaultValue = "你是谁") String msg) {
        return this.chatClient.prompt()
                .user(msg)
                .call()
                .content();
    }

    @GetMapping("/c1")
    public String chat1(@RequestParam(value = "msg", defaultValue = "你是谁") String msg) {
        return msg;
    }
}