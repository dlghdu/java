package org.example.tobi.springbootbasic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.tobi.springbootbasic.dto.MemberResponseDTO;

@Getter
@Setter
@Builder
public class User {
    private Long id;
    private String name;
    private String email;
    private String userid;
    private String password;

    public MemberResponseDTO toMemberResponseDTO() {
        return MemberResponseDTO.builder()
                .id(id)
                .name(name)
                .email(email)
                .userid(userid)
                .build();
    }

}
