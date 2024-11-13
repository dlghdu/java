package org.example.tobi.springbootsecurityhooyung.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.tobi.springbootsecurityhooyung.enums.Role;

@Getter
@Builder
public class UserInfoResponseDTO {
    private long id;
    private String userId;
    private String userName;
    private Role role;
}