package com.backend.tempo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/")
    public String hello() {
        return "Hello, World! This edit was deployed automatically with Github CI/CD. Checking if loadbalancer is working";
    }
}
