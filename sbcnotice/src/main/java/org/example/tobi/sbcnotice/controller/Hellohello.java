package org.example.tobi.sbcnotice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hellohello {

    @GetMapping("/hellohello")
    public String hellohello() {
        System.out.println("hi hello");
        return "hello";
    }

}
