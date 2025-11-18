package com.neusoft.neu23.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/c")
@CrossOrigin
public class DemoContoller {
    private int i =0;

    private String[] paths={  "http://localhost:18080/s/s1", "http://localhost:18081/s/s1"};

    @Autowired
//    能够使用HTTP协议访问其它Springboot微服务
    private RestTemplate restTemplate;
    @RequestMapping("/s")
    public String s1(){
        i++;
        int index = i%2;
        String jsonObj = restTemplate.getForObject(paths[index], String.class);
        return jsonObj ;
    }
}
