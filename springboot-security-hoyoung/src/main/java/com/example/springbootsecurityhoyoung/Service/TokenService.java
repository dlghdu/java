package com.example.springbootsecurityhoyoung.Service;

import com.example.springbootsecurityhoyoung.config.jwt.TokenProvider;
import com.example.springbootsecurityhoyoung.dto.RefreshTokenResponseDTO;
import com.example.springbootsecurityhoyoung.model.Member;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenProvider tokenProvider;

    public RefreshTokenResponseDTO refreshToken(Cookie[] cookies) {
        String refreshToken = getRefreshTokenFromCookies(cookies);

        if (refreshToken != null && tokenProvider.validateToken(refreshToken) == 1) {

            Member member = tokenProvider.getTokenDetails(refreshToken);

            // Access Token
            String newAccessToken = tokenProvider.generateToken(member, Duration.ofHours(2));

            // RefreshToken
            String newRefreshToken = tokenProvider.generateToken(member, Duration.ofDays(2));

            return RefreshTokenResponseDTO.builder()
                    .validated(true)
                    .accessToken(newAccessToken)
                    .refreshToken(newRefreshToken)
                    .build();

        }

        return RefreshTokenResponseDTO.builder()
                .validated(false)
                .build();

    }

    private String getRefreshTokenFromCookies(Cookie[] cookies) {

        if (cookies!= null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("refreshToken")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

}
