package org.example.tobi.sbcnode.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Heelo World!");
        return "hello";
    }

}
