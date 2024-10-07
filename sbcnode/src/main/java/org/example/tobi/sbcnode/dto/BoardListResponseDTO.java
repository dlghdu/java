package org.example.tobi.sbcnode.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.tobi.sbcnode.model.Board;

import java.util.List;

@Getter
@Builder
public class BoardListResponseDTO {
    List<Board> boards;
    boolean last;
}
