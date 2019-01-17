package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApp {
    public static void main(String[] args){
        SpringApplication.run(ProviderApp.class, args);
        //new SpringApplicationBuilder(ProviderApp.class).web(true).run(args);
    }
}
