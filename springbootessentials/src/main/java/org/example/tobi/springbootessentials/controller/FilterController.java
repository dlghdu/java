package org.example.tobi.springbootessentials.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestController와 Controller 차이
public class FilterController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/api/data")
    public String data() {
        return "Some data";
    }

}
