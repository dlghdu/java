package org.example.tobi.helloservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hihello")
    public String hello() {
        return "hello";
    }

}