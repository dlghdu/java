package org.example.tobi.springbootsecurityhooyung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/helo")
    public String hello() {
        return "hello";
    }

}
