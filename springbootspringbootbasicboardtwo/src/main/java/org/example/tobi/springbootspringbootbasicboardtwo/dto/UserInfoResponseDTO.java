package org.example.tobi.springbootspringbootbasicboardtwo.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.tobi.springbootspringbootbasicboardtwo.enums.Role;

@Getter
@Builder
public class UserInfoResponseDTO {
    private long id;
    private String userId;
    private String userName;
    private Role role;


}
