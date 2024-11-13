package com.example.springbootsecurityhoyoung.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

    @GetMapping("/")
    public String boardList() {
        return "boardlist";
    }

    @GetMapping("/detail")
    public String detail(
            @RequestParam("id") Long id,
            Model model
    ) {
        model.addAttribute("id", id);
        return "boarddetail";
    }

    @GetMapping("/write")
    public String write() {
        return "boardwrite";
    }

    @GetMapping("/update/{id}")
    public String update(
            @PathVariable Long id,
            Model model) {
        model.addAttribute("id", id);
        return "boardupdate";
    }
}