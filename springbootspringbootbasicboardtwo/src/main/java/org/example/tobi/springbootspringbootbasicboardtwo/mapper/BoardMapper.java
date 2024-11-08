package org.example.tobi.springbootspringbootbasicboardtwo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tobi.springbootspringbootbasicboardtwo.model.Board;
import org.example.tobi.springbootspringbootbasicboardtwo.model.Paging;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> selectBoardList(Paging page);
    int countBoards();
    Board selectBoardDetail(long id);
    void saveArticle(Board board);
    void deleteBoardById(long id);
    void updateArticle(Board board);
}
