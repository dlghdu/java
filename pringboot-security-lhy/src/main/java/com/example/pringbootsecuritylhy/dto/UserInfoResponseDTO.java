package com.example.pringbootsecuritylhy.dto;


import com.example.pringbootsecuritylhy.enums.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResponseDTO {
    private long id;
    private String userId;
    private String userName;
    private Role role;
}
