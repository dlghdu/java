package org.example.tobi.springbootsecurityhooyung.controller;

import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootsecurityhooyung.dto.SignupRequestDTO;
import org.example.tobi.springbootsecurityhooyung.dto.SignupResponseDTO;
import org.example.tobi.springbootsecurityhooyung.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberAPIController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDTO> signUp(@RequestBody SignupRequestDTO signupRequestDTO) {
        memberService.signUp(signupRequestDTO.toMember());
        return ResponseEntity.ok(
                SignupResponseDTO.builder()
                        .url("/login")
                        .build()
        );
    }
}
