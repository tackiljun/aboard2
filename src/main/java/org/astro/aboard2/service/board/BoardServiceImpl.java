package org.astro.aboard2.service.board;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.astro.aboard2.dto.BoardDTO;
import org.astro.aboard2.dto.PageRequestDTO;
import org.astro.aboard2.dto.PageResponseDTO;
import org.astro.aboard2.mappers.BoardMapper;
import org.astro.aboard2.mappers.FileMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    /////////////////////////////////////////////////////////////////////////////////////////////
    // 의존성 주입.
    private final BoardMapper boardMapper;
    private final FileMapper fileMapper;

    /////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO) {

        List<BoardDTO> list = boardMapper.getList(pageRequestDTO);
        long total = boardMapper.listCount(pageRequestDTO);

        return PageResponseDTO.<BoardDTO>withAll()
        .list(list)
            .total(total)
            .build();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public BoardDTO readOne(int bno) {
        
        return boardMapper.readOne(bno);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void insertOne(BoardDTO boardDTO) {

        int count = boardMapper.insertOne(boardDTO);
        
        // 파일명 list로 가져오기.
        List<String> fileNames = boardDTO.getFileNames();

        // 게시판에서 등록 성공, 파일이 등록되면 실행.
        if(count > 0 && boardDTO.getFileNames() != null && boardDTO.getFileNames().isEmpty()) {
        
            //bno 가져오기.
            int bno = boardDTO.getBno();
            log.info("bno:....." + bno);

            AtomicInteger index = new AtomicInteger();

            // 등록된 파일 fileNames에서 추출.
            List<Map<String, String>> list = fileNames.stream().map(str -> {
                // uuid 가져오기.
                String uuid = str.substring(0, 36);
                // 실제 파일명 가져오기.
                String fileName = str.substring(37);

                // map에 담기.
                return Map.of(
                    "uuid", uuid, 
                    "file_name", fileName, 
                    "bno", "" + bno, 
                    "ord",""+ index.getAndIncrement());
            }).collect(Collectors.toList());

            log.info(list);

            // 파일 등록 실행.
            fileMapper.insertImg(list);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int modifyOne(BoardDTO boardDTO) {
        return boardMapper.modifyOne(boardDTO);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int deleteOne(int bno) {
        return boardMapper.deleteOne(bno);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<String> getImg(int bno) {
        return fileMapper.selectImgs(bno);
    }
}
