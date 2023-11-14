package com.example.springadvanced.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrialController {
    @GetMapping("/user")
    public void get(){
        System.out.println("sadf");
    }
}
