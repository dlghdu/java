package org.example.tobi.springbootbasic.controller;

import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootbasic.dto.MemberCreatequestDTO;
import org.example.tobi.springbootbasic.dto.MemberDeleteUserResponceDTO;
import org.example.tobi.springbootbasic.dto.MemberResponseDTO;
import org.example.tobi.springbootbasic.dto.MemberUpdatequestDTO;
import org.example.tobi.springbootbasic.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String findAllUsers(Model model) {
        List<MemberResponseDTO> users = userService.findAll();
        System.out.println(users.size());
        model.addAttribute("users", users);
        return "userlist";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "signup";
    }

    // 방법 1
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        // 로직 추가.... -> id 조건으로 데이터 조회한 데이터를
        //프론트(수정)화면에 뿌릴 것.
        MemberResponseDTO user = userService.findById(id);
        model.addAttribute("user", user);
        return "userupdate";
    }

      // 방법 2
//    @GetMapping("/update")
//    public String updateForm(@RequestParam("id") Long id, Model model) {
//        System.out.println("id :: " + id);
//        return "userupdate";
//    }

    @GetMapping("/delete")
    public String deleteUser(
            @RequestParam("id") Long id,
            @RequestParam("userid") String userid,
            Model model
    ) {
        model.addAttribute(
                "user",
                MemberDeleteUserResponceDTO.builder()
                    .id(id)
                    .userid(userid)
                    .build()

        );
        return "userdelete";
    }

    @PostMapping("/register")
    public String createUser(@RequestBody MemberCreatequestDTO request) {
        userService.createUser( request.toUser() );
        return "redirect:/users";
    }

//    @PutMapping("/update/{id}")
//    public String updateUser(@PathVariable Long id, @RequestBody MemberchangeDTO request) {
//        MemberResponseDTO user = userService.findById(id);
//        userService.updateUser(user.getId(), request.toUser() );
//        return "redirect:/users";
//    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody MemberUpdatequestDTO request) {
        userService.updateUser( request.toUser() );
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteUser(@RequestBody MemberDeleteUserResponceDTO request) {
        userService.deleteUser( request.toUser() );
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
