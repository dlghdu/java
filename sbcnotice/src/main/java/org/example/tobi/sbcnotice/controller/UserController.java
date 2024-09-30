package org.example.tobi.sbcnotice.controller;

import lombok.RequiredArgsConstructor;
import org.example.tobi.sbcnotice.dto.MemberResponseDTO;
import org.example.tobi.sbcnotice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @GetMapping
    public String findlist(Model model) {
        List<MemberResponseDTO> users = userService.somefind();
        System.out.println(users.size());
        model.addAttribute("users", users);
        return "list";
    }

}