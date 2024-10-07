package org.example.tobi.sbcnode.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Board {
    private Long id;
    private String title;
    private String content;
    private String userId;
    private String created;
}
