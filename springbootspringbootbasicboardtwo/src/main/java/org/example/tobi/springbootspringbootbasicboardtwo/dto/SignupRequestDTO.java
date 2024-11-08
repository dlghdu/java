package org.example.tobi.springbootspringbootbasicboardtwo.dto;

import lombok.Getter;
import lombok.ToString;
import org.example.tobi.springbootspringbootbasicboardtwo.model.Member;
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
