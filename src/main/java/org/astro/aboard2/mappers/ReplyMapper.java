package org.astro.aboard2.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.astro.aboard2.dto.PageRequestDTO;
import org.astro.aboard2.dto.ReplyDTO;


public interface ReplyMapper {

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // 게시글에서 댓글가져오기.
    List<ReplyDTO> replyList(@Param("page") PageRequestDTO pageRequestDTO, @Param("bno") long bno);
    // 댓글등록.
    int insertReply(ReplyDTO replyDTO);
    // 댓글읽기.
    ReplyDTO readReply(int rno);
    // 댓글삭제.
    int deleteReply(int rno);
    // 댓글수정.
    int modifyReply(ReplyDTO replyDTO);
    // total.
    int total(int bno);
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
}
