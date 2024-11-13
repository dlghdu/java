package com.example.springbootsecurityhoyoung.dto;

import com.example.springbootsecurityhoyoung.model.Member;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@ToString
public class SignupRequestDTO {

    private String userId;
    private String password;
    private String userName;

    public Member toMember(BCryptPasswordEncoder bCryptPasswordEncoder) {
        return Member.builder()
                .userId(userId)
                .password(bCryptPasswordEncoder.encode(password))
                .userName(userName)
                .build();
    }
}
