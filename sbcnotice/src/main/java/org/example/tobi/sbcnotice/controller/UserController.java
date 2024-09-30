package org.example.tobi.sbcnotice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String findlist() {
        System.out.println("한번.... 두번....");
        return "list";
    }

}
