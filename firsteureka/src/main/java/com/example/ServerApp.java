package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Scanner;

@EnableEurekaServer
@SpringBootApplication
public class ServerApp {
    public static  void main(String[] args){
        //new SpringApplicationBuilder(ServerApp.class).web(true).run(args);
        Scanner scanner=new Scanner(System.in);
        String profiles=scanner.nextLine();       //读取配置文件
        //SpringApplication.run(ServerApp.class,args);
        new SpringApplicationBuilder(ServerApp.class).profiles(profiles).web(true).run(args);
    }
}
