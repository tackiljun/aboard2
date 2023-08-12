package org.astro.aboard2.service.reply;

import java.util.List;

import org.astro.aboard2.dto.PageRequestDTO;
import org.astro.aboard2.dto.PageResponseDTO;
import org.astro.aboard2.dto.ReplyDTO;
import org.astro.aboard2.mappers.ReplyMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    /////////////////////////////////////////////////////////////////////////////////////////
    // 의존성 주입.
    private final ReplyMapper replyMapper;

    /////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public PageResponseDTO<ReplyDTO> getReplyList(PageRequestDTO pageRequestDTO, int bno) {

        List<ReplyDTO> list = replyMapper.replyList(pageRequestDTO, bno);

        int total = replyMapper.total(bno);

        return PageResponseDTO.<ReplyDTO>withAll()
        .list(list)
        .total(total)
        .build();
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int insertReply(ReplyDTO replyDTO) {

        replyMapper.insertReply(replyDTO);
  
        return replyMapper.insertReply(replyDTO);
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ReplyDTO readReply(int rno) {
  
        return replyMapper.readReply(rno);
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int modifyReply(ReplyDTO replyDTO) {
      
        replyMapper.modifyReply(replyDTO);

        return replyMapper.modifyReply(replyDTO);
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int deleteReply(int rno) {
  
        replyMapper.deleteReply(rno);

        return replyMapper.deleteReply(rno);
    }
}
