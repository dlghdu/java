package org.example.tobi.springbootsecurityhooyung.dto;

import lombok.Getter;
import org.example.tobi.springbootsecurityhooyung.model.Member;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
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
