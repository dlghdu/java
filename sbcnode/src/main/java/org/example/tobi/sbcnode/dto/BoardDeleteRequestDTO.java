package org.example.tobi.sbcnode.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.tobi.sbcnode.model.Board;

import java.util.List;

@Getter
public class BoardDeleteRequestDTO {
    private String filePath;
}
