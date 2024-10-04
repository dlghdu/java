package org.example.tobi.sbcnode.dto;

import lombok.Getter;
import lombok.ToString;
import org.example.tobi.sbcnode.model.Member;

@Getter
@ToString
public class SignupRequestDTO {

    private String userId;
    private String password;
    private String userName;

    public Member toMember() {
//        return Member.builder()
//                .userId(userId)
//                .password(password)
//                .userName(userName)
//                .build();
        return Member.builder()
                .user_id(userId)
                .password(password)
                .user_name(userName)
                .build();
    }
}
