package com.example.springbootsecurityhoyoung.Service;


import com.example.springbootsecurityhoyoung.config.jwt.TokenProvider;
import com.example.springbootsecurityhoyoung.config.security.CustomUserDetails;
import com.example.springbootsecurityhoyoung.dto.LoginResponseDTO;
import com.example.springbootsecurityhoyoung.mapper.MemberMapper;
import com.example.springbootsecurityhoyoung.model.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    public void signUp(Member member) {
        memberMapper.signUp(member);
    }

    public LoginResponseDTO login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Member member = ((CustomUserDetails) authentication.getPrincipal()).getMember();
        // Access Token
        String accessToken = tokenProvider.generateToken(member, Duration.ofHours(2));
        // Refresh Token
        String refreshToken = tokenProvider.generateToken(member, Duration.ofDays(2));

        return LoginResponseDTO.builder()
                .isLoggedIn(true)
                .message("로그인 성공")
                .url("/")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(member.getUserId())
                .userName(member.getUserName())
                .build();
    }


    private LoginResponseDTO makeSignInRequestDTO(boolean isloggedIn, String message, String url, Member member) {
        return LoginResponseDTO.builder()
                .isLoggedIn(isloggedIn)
                .message(message)
                .url(url)
                .userId(isloggedIn ? member.getUserId() : null)
                .userName(isloggedIn ? member.getUserName() : null)
                .build();
    }

}