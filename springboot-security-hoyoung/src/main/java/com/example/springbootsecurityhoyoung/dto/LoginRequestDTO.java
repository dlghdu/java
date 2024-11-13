package com.example.springbootsecurityhoyoung.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LoginRequestDTO {

    private String userId;
    private String password;
}
