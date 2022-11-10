package com.cloud.logic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogicController {

    @GetMapping("get")
    public String get() {
        return "Feign Test";
    }
}
