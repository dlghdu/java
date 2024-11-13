package org.example.tobi.springbootsecurityhooyung.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.example.tobi.springbootsecurityhooyung.enums.Role;

@Getter
@Builder
@ToString
public class Member {
    private long id;
    private String userId;
    private String password;
    private String userName;
    private Role role;
}
