package com.neusoft.neu23.cfg;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterLocatorConfig {
    @Bean
    public RouteLocator baiduRouteLocator  (RouteLocatorBuilder builder) {
        return  builder.routes()
                .route("baidu", r -> r.path("/s")
                        .uri("http://www.baidu.com"))
                .route("jingdo", r -> r.path("/jd")
                        .uri("http://www.jd.com"))
                .build();
    }
}
