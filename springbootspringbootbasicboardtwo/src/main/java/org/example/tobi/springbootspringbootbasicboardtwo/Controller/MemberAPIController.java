package org.example.tobi.springbootspringbootbasicboardtwo.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootspringbootbasicboardtwo.Service.MemberService;
import org.example.tobi.springbootspringbootbasicboardtwo.dto.LoginResponseDTO;
import org.example.tobi.springbootspringbootbasicboardtwo.dto.SignupRequestDTO;
import org.example.tobi.springbootspringbootbasicboardtwo.dto.SignupResponseDTO;
import org.example.tobi.springbootspringbootbasicboardtwo.model.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberAPIController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder ;

    @PostMapping("/join")
    public ResponseEntity<SignupResponseDTO> signUp(@RequestBody SignupRequestDTO signupRequestDTO) {
        memberService.signUp(signupRequestDTO.toMember(bCryptPasswordEncoder));
        return ResponseEntity.ok(
                SignupResponseDTO.builder()
                        .url("/member/login")
                        .build()
        );
    }

//    @PostMapping("/login")
//    public ResponseEntity<LoginResponseDTO> Login(@RequestBody LoginRequestDTO loginRequestDTO, HttpSession session) {
//        return ResponseEntity.ok(
//                memberService.login(loginRequestDTO.toMember(), session)
//        );
//    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody Member member, HttpSession session) {
        // 로그인 요청 처리
        LoginResponseDTO response = memberService.login(member, session);

        if (response.isLoggedIn()) {
            // 로그인 성공시
            return ResponseEntity.ok(response);
        } else {
            // 로그인 실패시
            return ResponseEntity.status(400).body(response);
        }
    }

}
