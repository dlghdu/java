package com.example.sbcboardweather.dto;

import com.example.sbcboardweather.model.Member;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@ToString
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
