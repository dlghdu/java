package com.example.springbootsecurityhoyoung.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RefreshTokenResponseDTO {

    private boolean validated;
    private String accessToken;
    private String refreshToken;

}
