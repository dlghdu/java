package com.example.authservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class RefreshTokenRequestDTO {
    private String refreshToken;
}
