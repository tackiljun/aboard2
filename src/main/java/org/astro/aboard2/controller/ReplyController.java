package org.astro.aboard2.controller;

import java.util.Map;

import org.astro.aboard2.dto.PageRequestDTO;
import org.astro.aboard2.dto.PageResponseDTO;
import org.astro.aboard2.dto.ReplyDTO;
import org.astro.aboard2.service.reply.ReplyService;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/replies/")
public class ReplyController {

    //////////////////////////////////////////////////////////////////////////////
    // 의존성 주입.
    private final ReplyService replyService;

    //////////////////////////////////////////////////////////////////////////////
    @GetMapping(value = "{bno}/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponseDTO<ReplyDTO> getReplyList(
        @PathVariable("bno") int bno, PageRequestDTO pageRequestDTO) {

        log.info("GET ||||| ----------getReplyList----------");

        return replyService.getReplyList(pageRequestDTO, bno);
        
    }

    //////////////////////////////////////////////////////////////////////////////
    @PostMapping("{bno}/new")
    public Map<String, Integer> insertReply(
        @PathVariable("bno") int bno, 
        @RequestBody ReplyDTO replyDTO, 
        BindingResult bindingResult) throws BindException {

            replyDTO.setBno(bno);

            if(bindingResult.hasErrors()) {
                throw new BindException(bindingResult);
            }

            int rno = replyService.insertReply(replyDTO);

            log.info("POST ||||| ----------insertReply----------");

            return Map.of("RESULT", rno);

    }

    //////////////////////////////////////////////////////////////////////////////
    @GetMapping("read/{rno}")
    public ReplyDTO readReply(@PathVariable("rno") int rno) {

        log.info("GET ||||| ----------readReply----------");

        return replyService.readReply(rno);

    }

    //////////////////////////////////////////////////////////////////////////////
    @DeleteMapping("delete/{rno}")
    public Map<String, Integer> deleteReply(@PathVariable("rno") int rno) {

        replyService.deleteReply(rno);

        log.info("DELETE ||||| ----------deleteReply----------");

        return Map.of("result", rno);
  
    }

    //////////////////////////////////////////////////////////////////////////////
    @PutMapping("{rno}")
    public int modifyReply(@PathVariable("rno") int rno, ReplyDTO replyDTO) {

        log.info("PUT ||||| ----------modifyReply----------");

        return replyService.modifyReply(replyDTO);

    }
    
}
