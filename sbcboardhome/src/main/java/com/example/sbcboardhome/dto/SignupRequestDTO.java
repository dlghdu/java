package com.example.sbcboardhome.dto;

import com.example.sbcboardhome.model.Member;
import lombok.Getter;
import lombok.ToString;

@Getter
public class SignupRequestDTO {
    private String userId;
    private String password;
    private String userName;

    public Member toMember() {
        return Member.builder()
                .userId(userId)
                .password(password)
                .userName(userName)
                .build();
    }
}
