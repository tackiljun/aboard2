package org.astro.aboard2.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
public class PageResponseDTO<E> {

    ////////////////////////////////////////////////////
    // 목록 뽑아주는 List.
    private List<E> list;
    // getCountEnd를 담을 변수.
    private long total;
    // 페이지 번호,
    private int page;
    // 페이지 사이즈.
    private int size;

    ////////////////////////////////////////////////////
    @Builder(builderMethodName =  "withAll")
    public PageResponseDTO(List<E> list, long total) {
        this.list = list;
        this.total = total;
    }
}
