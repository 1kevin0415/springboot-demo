package com.neusoft.neu23.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/n")
@CrossOrigin
public class NacosDemoContoller {
    private static  final Random random = new Random( System.currentTimeMillis()  );

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/call")
    public String callProvider() {
//        从nacos中根据服务名获取服务实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("web-provider");
//        获得其中一个
        ServiceInstance instance = instances.get(random.nextInt( instances.size()  ) ); // 3-- > 0,1,2
//        从服务实例中获得服务地址和端口好，并且拼成URL
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/s/s1";
//        服务调用
        return restTemplate.getForObject(url, String.class);

    }

//    private NamingService namingService;
//    public NacosDemoContoller( ) throws NacosException {
//        // 初始化 Nacos 原生客户端
//        namingService = NacosFactory.createNamingService("127.0.0.1:8848");
//    }
}
