package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    public static boolean dbVisit=true;

    @GetMapping("/setDb/{status}")
    public void setDb(@PathVariable("status") boolean status){
        dbVisit=status;
    }

}
