package org.example.tobi.springbootsecurityhooyung.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.tobi.springbootsecurityhooyung.model.Board;


import java.util.List;

@Getter
@Builder
public class BoardListResponseDTO {
    List<Board> boards;
    boolean last;
}
