package org.example.tobi.sbcnode.Controller;

import lombok.RequiredArgsConstructor;
import org.example.tobi.sbcnode.Service.BoardService;
import org.example.tobi.sbcnode.dto.BoardDetailResponseDTO;
import org.example.tobi.sbcnode.dto.BoardListResponseDTO;
import org.example.tobi.sbcnode.model.Board;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardAPIController {

    private final BoardService boardService;

    @GetMapping
    public BoardListResponseDTO getBoardList (
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        // 게시글 목록 가져오기
        List<Board> boards = boardService.getBoardList(page, size);

        //  전체 게시글 수 가져오기
        int totalBoards = boardService.getTotalBoards();

        // 마지막 페이지 여부 계산
        boolean last = (page * size) >= totalBoards;

        return BoardListResponseDTO.builder()
                .boards(boards)
                .last(last)
                .build();
    }

    @GetMapping("/{id}")
    public BoardDetailResponseDTO getBoardDetail (@PathVariable long id) {
        Board boardDetail = boardService.getBoardDetail(id);
        return BoardDetailResponseDTO.builder()
                .title(boardDetail.getTitle())
                .content(boardDetail.getContent())
                .created(boardDetail.getCreated())
                .userId(boardDetail.getUserId())
                .build();
    }

    @PostMapping
    public ResponseEntity<Void> saveArticle(
            @RequestParam("title") String title,
            @RequestParam("hiddenUserId") String userId,
            @RequestParam("content") String content
            @RequestPart("file") MultipartFile file
    ) {
        boardService.saveArticle(userId, title, content, file);
        return ResponseEntity.ok().build();
    }

}
