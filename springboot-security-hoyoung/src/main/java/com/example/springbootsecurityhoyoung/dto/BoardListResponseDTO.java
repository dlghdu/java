package com.example.springbootsecurityhoyoung.dto;

import com.example.springbootsecurityhoyoung.model.Board;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BoardListResponseDTO {
    List<Board> boards;
    boolean last;
}
