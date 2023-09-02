package org.astro.aboard2.dto;

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
public class FileDTO {

    /////////////////////////////////////////////
    // uuid.
    private String uuid;
    // 파일명.
    private String fileName;
    // 이미지.
    private boolean img;

    /////////////////////////////////////////////
    // getLink.
    public String getLink() {

        if(img) {
            return "s_" + uuid + "_" + fileName;
        } else {
            return "default.jpg";
        }

    }
    
}
