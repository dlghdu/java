package org.example.tobi.springbootbasic.controller;

import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootbasic.dto.MemberCreatequestDTO;
import org.example.tobi.springbootbasic.dto.MemberListResponseDTO;
import org.example.tobi.springbootbasic.model.User;
import org.example.tobi.springbootbasic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String findAllUsers(Model model) {
        List<MemberListResponseDTO> users = userService.findAll();
        System.out.println(users.size());
        model.addAttribute("users", users);
        return "userlist";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "signup";
    }

    @PostMapping("/register")
    public String createUser(@RequestBody MemberCreatequestDTO request) {
        userService.createUser( request.toUser() );
        return "redirect:/users";
    }

}
