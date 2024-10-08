package org.example.tobi.sbcnode.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tobi.sbcnode.model.Board;
import org.example.tobi.sbcnode.model.Paging;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> selectBoardList(Paging page);
    int countBoards();
    Board selectBoardDetail(long id);
    void saveArticle(Board board);
    void deleteBoardById(long id);
}
