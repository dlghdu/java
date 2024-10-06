package com.example.sbcboardhome.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/join")
    public String SignUp() {
        System.out.println("회원가입");
        return "signup";
    }

    @GetMapping("/login")
    public String signIn() {
        return "signIn";
    }

}
