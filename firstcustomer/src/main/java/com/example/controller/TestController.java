package com.example.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration   //没有这个Bean没有初始化注入进去，会导致报错
public class TestController {
    @Bean
    @LoadBalanced      //初始化调用负载均衡的功能
    public RestTemplate getRestTemplate(){
        return new  RestTemplate();
    }

    @GetMapping("/router")
    public String router(){
        RestTemplate restTemplate=getRestTemplate();
       return  restTemplate.getForObject("http://PROVIDER/hello",String.class);
    }
}
