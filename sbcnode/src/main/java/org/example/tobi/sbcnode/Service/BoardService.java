package org.example.tobi.sbcnode.Service;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.tobi.sbcnode.dto.BoardDeleteRequestDTO;
import org.example.tobi.sbcnode.dto.LoginResponseDTO;
import org.example.tobi.sbcnode.mapper.BoardMapper;
import org.example.tobi.sbcnode.mapper.MemberMapper;
import org.example.tobi.sbcnode.model.Board;
import org.example.tobi.sbcnode.model.Member;
import org.example.tobi.sbcnode.model.Paging;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;
    private final FileService fileService;

    public List<Board> getBoardList(int page, int size) {
        int offset = (page - 1) * size; // 페이지는 1부터 시작, offset 계산
        return boardMapper.selectBoardList(
                Paging.builder()
                        .offset(offset)
                        .size(size)
                        .build()
        );
    }

    public int getTotalBoards() {
        return boardMapper.countBoards(); // 총 게시글 수 반환
    }

    public Board getBoardDetail(long id) {
        return boardMapper.selectBoardDetail(id);
    }

    public void saveArticle(String userId, String title, String content, MultipartFile file) {
        String path = null;

        if (!file.isEmpty()) {
            path = fileService.fileUpload(file);
        }

        boardMapper.saveArticle(
                Board.builder()
                        .title(title)
                        .content(content)
                        .userId(userId)
                        .filePath(path)
                        .build()
        );
    }

    public Resource downloadFile(String fileName) {
        return fileService.downloadFile(fileName);
    }

    public void deleteArticle(long id, BoardDeleteRequestDTO request) {
        boardMapper.deleteBoardById(id);
        fileService.deleteFile(request.getFilePath());
    }

}