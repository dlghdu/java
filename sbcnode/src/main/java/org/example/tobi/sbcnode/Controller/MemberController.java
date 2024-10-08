package org.example.tobi.sbcnode.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String signUp() {
        return "signup";
    }

    @GetMapping("/login")
    public String signIn() {
        return "loginn";
    }

}