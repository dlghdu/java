package org.example.tobi.springbootspringbootbasicboardtwo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.example.tobi.springbootspringbootbasicboardtwo.enums.Role;

@Getter
@Builder
@ToString
public class Member {
    private Long id;
    private String userId;
    private String password;
    private String userName;
    private Role role;

}
