package org.example.tobi.sbcnode.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.tobi.sbcnode.Service.MemberService;
import org.example.tobi.sbcnode.dto.LoginRequestDTO;
import org.example.tobi.sbcnode.dto.LoginResponseDTO;
import org.example.tobi.sbcnode.dto.SignupRequestDTO;
import org.example.tobi.sbcnode.dto.SignupResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/login")
//    public ResponseEntity<SignInResponseDTO> signIn(@RequestBody SignInRequestDTO signInRequestDTO, HttpSession session) {
//        return ResponseEntity.ok(
//                memberService.signIn(signInRequestDTO.toMember(), session)
//        );
//    }

}
