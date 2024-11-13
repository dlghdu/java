package org.example.tobi.springbootsecurityhooyung.Controller;

import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootsecurityhooyung.Service.MemberService;
import org.example.tobi.springbootsecurityhooyung.dto.LoginRequestDTO;
import org.example.tobi.springbootsecurityhooyung.dto.LoginResponseDTO;
import org.example.tobi.springbootsecurityhooyung.dto.SignupRequestDTO;
import org.example.tobi.springbootsecurityhooyung.dto.SignupResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberAPIController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/join")
    public ResponseEntity<SignupResponseDTO> signUp(@RequestBody SignupRequestDTO signUpRequestDTO) {
        memberService.signUp(signUpRequestDTO.toMember(bCryptPasswordEncoder));
        return ResponseEntity.ok(
                SignupResponseDTO.builder()
                        .url("/member/login")
                        .build()
        );
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return null;
    }
}
