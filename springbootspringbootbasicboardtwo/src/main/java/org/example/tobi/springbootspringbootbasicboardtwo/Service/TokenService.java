package org.example.tobi.springbootspringbootbasicboardtwo.Service;

import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootspringbootbasicboardtwo.config.jwt.TokenProvider;
import org.example.tobi.springbootspringbootbasicboardtwo.dto.RefreshTokenResponseDTO;
import org.example.tobi.springbootspringbootbasicboardtwo.model.Member;
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
