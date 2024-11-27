package com.example.authservice.model;

import com.example.authservice.enums.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private long id;
    private String userId;
    private String password;
    private String userName;
    private Role role;
}
