package com.example.sbcboardhome.Controller;

import com.example.sbcboardhome.Service.MemberService;
import com.example.sbcboardhome.dto.SignupRequestDTO;
import com.example.sbcboardhome.dto.SignupResponceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.stream.DoubleStream;

@Controller
@RequiredArgsConstructor
public class MemberAPIController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<SignupResponceDTO> signUp(@RequestBody SignupRequestDTO signupRequestDTO) {
        memberService.signUp(signupRequestDTO.toMember());
        return ResponseEntity.ok(
                SignupResponceDTO.builder()
                        .url("/member/login")
                        .build()
        );
    }


}
