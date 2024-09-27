package org.example.tobi.springbootbasic.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.tobi.springbootbasic.model.User;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
public class MemberchangeDTO {
    private String name;
    private String email;
    private String userid;

    public User toUser() {
        return User.builder()
                .name(name)
                .email(email)
                .userid(userid)
                .build();
    }

}
