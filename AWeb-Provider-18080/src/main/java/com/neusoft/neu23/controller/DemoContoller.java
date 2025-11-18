package com.neusoft.neu23.controller;

import com.neusoft.neu23.entity.Dept;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s")
@CrossOrigin
public class DemoContoller {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/s1")
    public Dept s1(){
        Dept dept = new Dept();
        dept.setDeptno(port);
        return dept;
    }
}
