package com.example.controller;

import com.example.entity.Person;
import javafx.application.Application;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/hello")
public class HelloController {
    @GetMapping
    public String hello(){
        return "hello world";
    }

    @GetMapping(value="/person",produces = "application/json" )
    public Person Person(HttpServletRequest httpServletRequest){
        Person person=new Person();
        person.setId(1);
        person.setName("zrq");
        person.setAge(24);
        person.setMessage(httpServletRequest.getRequestURL().toString());
        return person;
    }
}
