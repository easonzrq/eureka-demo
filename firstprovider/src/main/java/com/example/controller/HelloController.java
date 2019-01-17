package com.example.controller;

import com.example.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello")
public class HelloController {
    @GetMapping
    public String hello(){
        return "hello world";
    }

    @GetMapping("/person")
    public Person Person(){
        Person person=new Person();
        person.setId(1);
        person.setName("zrq");
        person.setAge(24);
        return person;
    }
}
