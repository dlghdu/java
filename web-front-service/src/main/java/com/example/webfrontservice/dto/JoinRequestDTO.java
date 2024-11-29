
package com.example.webfrontservice.dto;

import com.example.webfrontservice.eums.Role;
import lombok.Getter;

@Getter
public class JoinRequestDTO {
    private String userId;
    private String password;
    private String userName;
    private Role role;
}