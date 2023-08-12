package org.astro.aboard2.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReplyDTO {

    /////////////////////////
    // PK값 - rno.
    private int rno;
    // 게시글번호 - bno.
    @NotNull
    private int bno;
    // 댓글내용.
    @NotEmpty
    private String reply;
    // 댓글작성자.
    @NotEmpty
    private String replyer;

    /////////////////////////
    // 대댓글작업?????
    @Builder.Default
    private int gno = 0;
    private int step;
    //댓글 삭제여부.
    private boolean status;
    
}
