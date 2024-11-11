package org.example.tobi.springbootspringbootbasicboardtwo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LogoutResponseDTO {
    private String message;
    private String url;
}
