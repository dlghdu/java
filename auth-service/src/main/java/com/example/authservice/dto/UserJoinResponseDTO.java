package com.example.authservice.dto;

import com.example.authservice.enums.Role;
import com.example.authservice.model.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Builder
public class UserJoinResponseDTO {
    private boolean isSuccess;
}
