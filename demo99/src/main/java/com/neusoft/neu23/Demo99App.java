package com.neusoft.neu23;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
// MapperScan : 指定mapper接口的包名,目的是生成mapper接口的代理对象，并且添加到spring容器中
@MapperScan("com.neusoft.neu23.mapper")

public class Demo99App
{
    public static void main( String[] args ){
        SpringApplication.run(Demo99App.class,args);
        System.out.println( "Hello World!" );
    }
}
