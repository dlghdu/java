package com.example.authservice.dto;

import com.example.authservice.enums.Role;
import com.example.authservice.model.User;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
public class UserJoinRequestDTO {

    private String userId;
    private String password;
    private String userName;
    private Role role;

    public User touser(BCryptPasswordEncoder bCryptPasswordEncoder) {
        return User.builder()
                .userId(userId)
                .password(password)
                .userName(userName)
                .role(role)
                .build();
    }

}
