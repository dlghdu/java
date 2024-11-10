package org.example.tobi.sbcnode.dto;

import lombok.Getter;
import lombok.ToString;
import org.example.tobi.sbcnode.model.Member;
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
