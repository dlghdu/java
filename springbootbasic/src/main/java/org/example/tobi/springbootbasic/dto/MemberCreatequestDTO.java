package org.example.tobi.springbootbasic.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.tobi.springbootbasic.model.User;

@Getter
public class MemberCreatequestDTO {
    private String name;
    private String email;
    private String userid;
    private String password;

    public User toUser() {
        return User.builder()
                .name(name)
                .email(email)
                .userid(userid)
                .password(password)
                .build();
    }
}

