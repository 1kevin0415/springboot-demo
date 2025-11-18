package com.neusoft.neu23.controller;

import com.neusoft.neu23.tc.DateTimeTools;
import com.neusoft.neu23.tc.GuestTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import static com.neusoft.neu23.cfg.AiConfig.TOOLCALLING_PROMPT;

@RequestMapping("/d")
@RestController
@CrossOrigin
public class Demo99Controller {
    private     ChatClient  chatClient;
    public Demo99Controller(OpenAiChatModel openAiChatModel, ChatMemory  chatMemory ,
                            DateTimeTools dateTimeTools,
                            GuestTools guestTools
    ) {
        this.chatClient = ChatClient.builder(openAiChatModel)
                .defaultSystem(TOOLCALLING_PROMPT) // 默认系统角色
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultAdvisors( new SimpleLoggerAdvisor() )
                .defaultTools(dateTimeTools)
                .defaultTools(   guestTools)
                .build();
    }
    @GetMapping("/c1")
    public String chat1(@RequestParam(value = "msg",defaultValue = "你是谁") String msg,
                        @RequestParam( value = "chatId" ,defaultValue = "neu.edu.cn") String chatId
    ){
        return this.chatClient.prompt()
                .user(msg)  // 提交给大模型的问题
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                .call()
                .content();
    }

}
