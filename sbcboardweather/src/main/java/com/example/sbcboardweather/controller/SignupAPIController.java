package com.example.sbcboardweather.controller;

import com.example.sbcboardweather.dto.SigninReponseDTO;
import com.example.sbcboardweather.dto.SigninRequestDTO;
import com.example.sbcboardweather.dto.SignupRequestDTO;
import com.example.sbcboardweather.dto.SignupResponseDTO;
import com.example.sbcboardweather.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignupAPIController {

    private final MemberService memberService;


    @PostMapping("/register")
    public ResponseEntity<SignupResponseDTO> signUp(@RequestBody SignupRequestDTO signupRequestDTO) {
        memberService.signUp(signupRequestDTO.toMember());
        return ResponseEntity.ok(
                SignupResponseDTO.builder()
                        .url("/login")
                        .build()
        );
    }

    @PostMapping("/login")
    public ResponseEntity<SigninReponseDTO> login(@RequestBody SigninRequestDTO signinRequestDTO, HttpSession session) {
        return ResponseEntity.ok(
                memberService.signin(signinRequestDTO.toMember(), session)
        );
    }
}
