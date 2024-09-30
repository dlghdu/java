package org.example.tobi.springbootbasic.dto;

import lombok.Getter;
import lombok.ToString;
import org.example.tobi.springbootbasic.model.User;

@Getter
@ToString
public class MemberUpdatequestDTO {
    private Long id;
    private String name;
    private String email;
    private String userid;

    public User toUser() {
        return User.builder()
            .id(id)
            .name(name)
            .email(email)
            .userid(userid)
            .build();
    }
}

