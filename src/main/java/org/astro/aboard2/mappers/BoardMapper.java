package org.astro.aboard2.mappers;

import java.util.List;

import org.astro.aboard2.dto.BoardDTO;
import org.astro.aboard2.dto.FileDTO;
import org.astro.aboard2.dto.PageRequestDTO;


public interface BoardMapper {

    ///////////////////////////////////////////////////////
    // 리스트목록.
    List<BoardDTO> getList(PageRequestDTO pageRequestDTO);
    // 한개 불러오기.
    BoardDTO readOne(int bno);
    // 등록.
    int insertOne(BoardDTO boardDTO);
    // 삭제.
    int deleteOne(int bno);
    // 수정.
    int modifyOne(BoardDTO boardDTO);

    long listCount(PageRequestDTO pageRequestDTO);

    ///////////////////////////////////////////////////////
    //파일업로드.
    Long setBoard(BoardDTO boardDTO);

    void setBoardImg(FileDTO fileDTO);
}
