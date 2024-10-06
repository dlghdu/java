package com.example.sbcboardhome.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hihello")
    public String hihello() {
        System.out.println("bye");
        return "hello";
    }

}