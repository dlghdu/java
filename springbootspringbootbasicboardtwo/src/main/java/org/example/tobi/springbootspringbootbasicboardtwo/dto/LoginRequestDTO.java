package org.example.tobi.springbootspringbootbasicboardtwo.dto;

import lombok.Getter;
import lombok.ToString;
import org.example.tobi.springbootspringbootbasicboardtwo.model.Member;

@Getter
@ToString
public class LoginRequestDTO {

    private String userId;
    private String password;

    public Member toMember() {
        return Member.builder()
                .userId(userId)
                .password(password)
                .build();
    }
}
