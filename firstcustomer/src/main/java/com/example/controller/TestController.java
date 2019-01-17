package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/list")
    public Integer getCount(){
        Integer sum=0;
        List<String> names=discoveryClient.getServices();
        for(String instanceId:names){
            List<ServiceInstance> instances=discoveryClient.getInstances(instanceId);
            sum=sum+instances.size();
        }
        return  sum;
        //return discoveryClient.getServices().size();
    }

    @GetMapping("/meta")
    public String getMetaData(){
        List<ServiceInstance> instances=discoveryClient.getInstances("provider");
        for(ServiceInstance serviceInstance:instances){
            return "author:"+serviceInstance.getMetadata().get("author");
        }
        return null;
    }
}
