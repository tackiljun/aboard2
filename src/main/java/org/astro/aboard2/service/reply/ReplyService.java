package org.astro.aboard2.service.reply;

import org.astro.aboard2.dto.PageRequestDTO;
import org.astro.aboard2.dto.PageResponseDTO;
import org.astro.aboard2.dto.ReplyDTO;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface ReplyService {

    ////////////////////////////////////////////////////////////////////////////////
    PageResponseDTO<ReplyDTO> getReplyList(PageRequestDTO pageRequestDTO, int bno);

    ReplyDTO readReply(int rno);

    int insertReply(ReplyDTO replyDTO);

    int deleteReply(int rno);

    int modifyReply(ReplyDTO replyDTO);
}
