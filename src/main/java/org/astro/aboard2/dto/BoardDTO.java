package org.astro.aboard2.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    
    ////////////////////////////////
    // 번호.
    private int bno;
    // 제목.
    private String title;
    // 내용.
    private String content;
    // 작성자.
    private String writer;
    // 등록일.
    private String duedate;
    
    ////////////////////////////////
    // 파일 리스트 
    private List<String> fileNames;
}
