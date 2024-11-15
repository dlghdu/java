package com.example.pringbootsecuritylhy.service;


import com.example.pringbootsecuritylhy.config.jwt.TokenProvider;
import com.example.pringbootsecuritylhy.config.security.CustomUserDetails;
import com.example.pringbootsecuritylhy.dto.SignInResponseDTO;
import com.example.pringbootsecuritylhy.mapper.MemberMapper;
import com.example.pringbootsecuritylhy.model.Member;
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

    public SignInResponseDTO signIn(String username, String password) {
        System.out.println("0");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)

        );
        System.out.println("1");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("2");
        Member member = ((CustomUserDetails) authentication.getPrincipal()).getMember();
        System.out.println("3");
        // Access Token
        String accessToken = tokenProvider.generateToken(member, Duration.ofHours(2));
        System.out.println("access token:: " + accessToken);

        // Refresh Token
        String refreshToken = tokenProvider.generateToken(member, Duration.ofDays(2));
        System.out.println("4");
        return SignInResponseDTO.builder()
                .isLoggedIn(true)
                .message("로그인 성공")
                .url("/")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(member.getUserId())
                .userName(member.getUserName())
                .build();
    }


    private SignInResponseDTO makeSignInRequestDTO(boolean isloggedIn, String message, String url, Member member) {
        return SignInResponseDTO.builder()
                .isLoggedIn(isloggedIn)
                .message(message)
                .url(url)
                .userId(isloggedIn ? member.getUserId() : null)
                .userName(isloggedIn ? member.getUserName() : null)
                .build();
    }

}
