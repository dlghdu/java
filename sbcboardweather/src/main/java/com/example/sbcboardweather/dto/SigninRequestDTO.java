package com.example.sbcboardweather.dto;

import com.example.sbcboardweather.model.Member;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SigninRequestDTO {

    private String userId;
    private String password;

    public Member toMember() {
        return Member.builder()
                .userId(userId)
                .password(password)
                .build();
    }
}
