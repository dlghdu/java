package org.example.tobi.springbootspringbootbasicboardtwo.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.tobi.springbootspringbootbasicboardtwo.model.Board;

import java.util.List;

@Getter
@Builder
public class BoardListResponseDTO {
    List<Board> boards;
    boolean last;
}
