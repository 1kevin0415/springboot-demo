package com.neusoft.neu23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AWebProver18080App
{
    public static void main( String[] args )
    {
        SpringApplication.run(AWebProver18080App.class, args);
        System.out.println( "Hello World!" );
    }
}
