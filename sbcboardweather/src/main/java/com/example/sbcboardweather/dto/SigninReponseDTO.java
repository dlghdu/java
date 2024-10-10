package com.example.sbcboardweather.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SigninReponseDTO {
    private boolean isLoggedIn;
    private String url;
    private String userName;
    private String userId;
    private String message;
}
