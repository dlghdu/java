package org.example.tobi.springbootsecurityhooyung.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponseDTO {
    private boolean isLoggedIn;
    private String url;
    private String userId;
    private String userName;
    private String message;
}