package org.example.tobi.sbcnode.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.tobi.sbcnode.Service.MemberService;
import org.example.tobi.sbcnode.dto.LoginRequestDTO;
import org.example.tobi.sbcnode.dto.LoginResponseDTO;
import org.example.tobi.sbcnode.dto.SignupRequestDTO;
import org.example.tobi.sbcnode.dto.SignupResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberAPIController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<SignupResponseDTO> signUp(@RequestBody SignupRequestDTO signupRequestDTO) {
        memberService.signUp(signupRequestDTO.toMember());
        return ResponseEntity.ok(
                SignupResponseDTO.builder()
                        .url("/member/login")
                        .build()
        );
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> Login(@RequestBody LoginRequestDTO loginRequestDTO, HttpSession session) {
        return ResponseEntity.ok(
                memberService.login(loginRequestDTO.toMember(), session)
        );
    }

}
