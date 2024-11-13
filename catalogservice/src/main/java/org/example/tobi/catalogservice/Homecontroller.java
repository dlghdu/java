package org.example.tobi.catalogservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homecontroller {

    @GetMapping("/")
    public String home() {
        return "Cartalog Service에 오신걸 환영합니다!";
    }

}
