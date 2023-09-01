package org.astro.aboard2.controller;

import org.astro.aboard2.dto.BoardDTO;
import org.astro.aboard2.dto.PageRequestDTO;
import org.astro.aboard2.dto.PageResponseDTO;
import org.astro.aboard2.service.board.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    //////////////////////////////////////////////////////////////////////////////////////
    // 의존성 주입.
    private final BoardService boardService;

    //////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////
    // GET.
    // list.
    @GetMapping("list")
    public void getList(PageRequestDTO pageRequestDTO, Model model) {

        PageResponseDTO<BoardDTO> pageResponseDTO = boardService.getList(pageRequestDTO);

        log.info("GET ||||| ----------LIST----------");

        model.addAttribute("pageResponseDTO", pageResponseDTO);
    }

    // read.
    @GetMapping("read/{bno}")
    public String getRead(@PathVariable("bno") int bno, Model model) {

        model.addAttribute("dto", boardService.readOne(bno));

        log.info("GET ||||| ----------READ----------");

        return "/board/read";
    }

    // regist.
    @GetMapping("regist")
    public void getRegist(BoardDTO boardDTO) {

        log.info("GET ||||| ----------REGIST----------");
    }

    // modify.
    @GetMapping("modify/{bno}")
    public String getModify(@PathVariable("bno") int bno, Model model) {

        model.addAttribute("dto", boardService.readOne(bno));

        log.info("GET ||||| ----------MODIFY----------");

        return "/board/modify";
    }
    
    //////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////
    // POST.
    // regist.
    @PostMapping("/regist")
    public String postRegist(BoardDTO boardDTO) {

        boardService.insertOne(boardDTO);

        log.info("POST ||||| ----------REGIST----------");

        return "redirect:/board/list";
        
    }

    // modify.
    @PostMapping("/modify/{bno}")
    public String postModify(@PathVariable("bno") int bno, BoardDTO boardDTO) {

        boardService.modifyOne(boardDTO);

        log.info("POST ||||| ----------MODIFY----------");

        return "redirect:/board/read/" + bno;

    }

    // delete.
    @PostMapping("delete/{bno}")
    public String postDelete(@PathVariable("bno") int bno) {

        boardService.deleteOne(bno);

        log.info("POST ||||| ----------DELETE----------");

        return "redirect:/board/list";

    }

}
