package org.example.tobi.sbcnotice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberResponseDTO {
    private Long number;
    private String title;
    private String name;
    private String day;


}
