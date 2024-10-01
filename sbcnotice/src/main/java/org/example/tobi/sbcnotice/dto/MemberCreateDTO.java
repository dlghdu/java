package org.example.tobi.sbcnotice.dto;

import lombok.Getter;
import org.example.tobi.sbcnotice.model.noticee;

@Getter
public class MemberCreateDTO {
    private String email;
    private String name;
    private String phone;
    private String userid;
    private String password;

    public noticee toUser() {
        return noticee.builder()
                .email(email)
                .name(name)
                .phone(phone)
                .userid(userid)
                .password(password)
                .build();
    }
}
