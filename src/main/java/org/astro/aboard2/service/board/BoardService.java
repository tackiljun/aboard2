package org.astro.aboard2.service.board;

import java.util.List;

import org.astro.aboard2.dto.BoardDTO;
import org.astro.aboard2.dto.PageRequestDTO;
import org.astro.aboard2.dto.PageResponseDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface BoardService {
  
    //////////////////////////////////////////////////////////////////
    PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO);

    BoardDTO readOne(int bno);

    void insertOne(BoardDTO boardDTO);

    int modifyOne(BoardDTO boardDTO);

    int deleteOne(int bno);
    
    //////////////////////////////////////////////////////////////////
    // 파일 업로드.
    List<String> getImg(int bno);
}
