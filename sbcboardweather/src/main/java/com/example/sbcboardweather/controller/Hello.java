package com.example.sbcboardweather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {

    @GetMapping("/hi")
    public String hi() {
        return "hello";
    }
}
