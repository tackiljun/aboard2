package org.astro.aboard2.dto;

import java.io.UnsupportedEncodingException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PageRequestDTO {

    ////////////////////////////////////////////////////////////////
    // 페이지번호.
    @Builder.Default
    private int page = 1;
    // 사이즈.
    @Builder.Default
    private int size = 10;
    // 타입.
    private String type;
    // 키워드.
    private String keyword;
    // 링크.
    private String link;

    ////////////////////////////////////////////////////////////////
    // page번호 음수제외.
    public void setPage(int page) {
        if(page <= 0){
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    ////////////////////////////////////////////////////////////////
    // size 음수값, 과도한 값 제외.
    public void setSize(int size) {
        if(size > 100 || size < 0){
            this.size = 10;
        } else {
            this.size = size;
        }
    }

    ////////////////////////////////////////////////////////////////
    // limit에 들어갈 skip계산.
    public int getSkip() {
        return (this.page -1) * this.size;
    }

    ////////////////////////////////////////////////////////////////
    // 끝계산.
    public int getEnd() {
        return this.page * this.size;
    }

    ////////////////////////////////////////////////////////////////
    // 다음페이지를 위한 count.
    public int getCountEnd() {
        int temp = (int) (Math.ceil(this.page/10.0)) * (10 * size);

        return temp + 1;
    }

    ////////////////////////////////////////////////////////////////
    // public String getLink() {

    //     if(link == null) {

    //         StringBuilder stringBuilder = new StringBuilder();

    //         stringBuilder.append("page" + this.page);
    //         stringBuilder.append("size" + this.size);

    //         if(type != null && type.length() > 0) {
    //             stringBuilder.append("type= " + this.type);
    //         }

    //         if(keyword != null) {

    //             try {
    //                 stringBuilder.append("keyword= " + URLEncoder.encode(keyword, "UTF-8"));
    //             } catch (UnsupportedEncodingException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //         // toString으로 전달.
    //         link = stringBuilder.toString();
    //     }
    //     return link;
    // }
}
