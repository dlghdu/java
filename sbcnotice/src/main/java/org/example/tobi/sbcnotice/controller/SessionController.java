package org.example.tobi.sbcnotice.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionController {

    @GetMapping("/login")
    public String login(
            HttpSession session,
            Model model
    ) {
        String userid = (String) session.getAttribute("userid");
        String password = (String) session.getAttribute("password");

        if(password != null) {
            model.addAttribute("userid", userid);
            model.addAttribute("password", password);
        }
        return "login";
    }

    @PostMapping("/login") // html form 태그일때 RequestParam
    public String loginExc(
            @RequestParam String userid,
            @RequestParam String password,
            HttpSession session
    ) {

        session.setAttribute("userid", userid);
        session.setAttribute("password", password);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션 무효화
        session.invalidate();
        return "redirect:/login";
    }
}
