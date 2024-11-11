package org.example.tobi.springbootspringbootbasicboardtwo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootspringbootbasicboardtwo.Service.MemberService;
import org.example.tobi.springbootspringbootbasicboardtwo.dto.*;
import org.example.tobi.springbootspringbootbasicboardtwo.model.Member;
import org.example.tobi.springbootspringbootbasicboardtwo.util.CookieUtil;
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

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> signIn(
            @RequestBody LoginRequestDTO signInRequestDTO,
            HttpServletResponse response
    ) {
        LoginResponseDTO signInResponseDTO = memberService.login(signInRequestDTO.getUserId(), signInRequestDTO.getPassword());

        CookieUtil.addCookie(response, "refreshToken", signInResponseDTO.getRefreshToken(), 7 * 24 * 60 * 60);
        signInResponseDTO.setRefreshToken(null);

        return ResponseEntity.ok(signInResponseDTO);
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponseDTO> logout(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.deleteCookie(request, response, "refreshToken");
        return ResponseEntity.ok(
                LogoutResponseDTO.builder()
                        .message("로그아웃 되었습니다.")
                        .url("/member/login")
                        .build()
        );
    }

    @GetMapping("/user/info")
    public ResponseEntity<UserInfoResponseDTO> getUserInfo(HttpServletRequest request) {
        Member member = (Member) request.getAttribute("member");
        return ResponseEntity.ok(
                UserInfoResponseDTO.builder()
                        .id(member.getId())
                        .userId(member.getUserId())
                        .userName(member.getUserName())
                        .role(member.getRole())
                        .build()
        );
    }

}