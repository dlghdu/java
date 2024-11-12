package org.example.tobi.springbootspringbootbasicboardtwo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootspringbootbasicboardtwo.Service.TokenService;
import org.example.tobi.springbootspringbootbasicboardtwo.dto.RefreshTokenResponseDTO;
import org.example.tobi.springbootspringbootbasicboardtwo.util.CookieUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenAPIController {

    private final TokenService tokenService;

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(HttpServletRequest request, HttpServletResponse response) {

        RefreshTokenResponseDTO refreshTokenResponseDTO = tokenService.refreshToken(request.getCookies());

        if (refreshTokenResponseDTO.isValidated()) {
            CookieUtil.addCookie(response, "refreshToken", refreshTokenResponseDTO.getRefreshToken(), 7 * 24 * 60 * 60);
            refreshTokenResponseDTO.setRefreshToken(null);

            return ResponseEntity.ok(refreshTokenResponseDTO);
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Refresh token expired");

    }

}
