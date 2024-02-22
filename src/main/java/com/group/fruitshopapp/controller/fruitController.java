package com.group.fruitshopapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fruitController {
    @GetMapping
    public String testGet(@RequestParam String testMessage){
        return testMessage + " Hello, ";
    }
}
