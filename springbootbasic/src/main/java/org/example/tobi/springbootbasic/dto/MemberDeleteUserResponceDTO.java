package org.example.tobi.springbootbasic.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.tobi.springbootbasic.model.User;

@Getter
@Builder
public class MemberDeleteUserResponceDTO {
    public Long id;
    private String userid;
    private String password;

    public User toUser() {
        return User.builder()
                .id(id)
                .userid(userid)
                .password(password)
                .build();
    }
}
