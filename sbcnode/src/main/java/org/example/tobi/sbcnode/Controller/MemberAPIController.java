package org.example.tobi.sbcnode.Controller;

import lombok.RequiredArgsConstructor;
import org.example.tobi.sbcnode.Service.MemberService;
import org.example.tobi.sbcnode.dto.SignupRequestDTO;
import org.example.tobi.sbcnode.dto.SignupResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberAPIController {

    private final MemberService memberService;

//    @PostMapping("/join")
//    public ResponseEntity<SignupResponseDTO> signUp(@RequestBody SignupRequestDTO signUpRequestDTO) {
//        memberService.signUp(signUpRequestDTO.toMember());
//        return ResponseEntity.ok(
//                SignupResponseDTO.builder()
//                        .url("/member/login")
//                        .build()
//        );
//    }

    @PostMapping("/join")
    public ResponseEntity<SignupResponseDTO> signUp(@RequestBody SignupRequestDTO signupRequestDTO) {
        memberService.Signup(signupRequestDTO.toMember());
        return ResponseEntity.ok(
                SignupResponseDTO.builder()
                        .url("/member/login")
                        .build()
        );
    }

}
