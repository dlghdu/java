package org.example.tobi.sbcnotice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.tobi.sbcnotice.dto.MemberResponseDTO;

@Getter
@Setter
@Builder
public class noticee {
    private Long number;
    private String title;
    private String day;
    private String name;
    private String email;
    private String phone;
    private String userid;
    private String password;

    public MemberResponseDTO toMemberResponceDTO() {
        return MemberResponseDTO.builder()
                .number(number)
                .title(title)
                .name(name)
                .day(day)
                .build();
    }

}
