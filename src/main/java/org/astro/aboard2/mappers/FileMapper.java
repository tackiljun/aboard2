package org.astro.aboard2.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.astro.aboard2.dto.BoardDTO;
import org.astro.aboard2.dto.FileDTO;
import org.astro.aboard2.dto.PageRequestDTO;


public interface FileMapper {

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    List<FileDTO> getList(PageRequestDTO pageRequestDTO);
    // img regist.
    int insertImg(List<Map<String, String>> imgList);
    // img delete.
    int deleteImg(int bno);

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Select("select * from tbl_board b where b.bno = #{bno}")
    BoardDTO getOne(int bno);

    @Select("select concat(uuid, '_' , fileName) fileName from tbl_board_image where bno = #{bno} order by ord")
    List<String> selectImgs(int bno);

    @Update("update tbl_board set bname=#{bname}, price=#{price}, status=#{status} where bno=#{bno}")
    int modifyImgs(FileDTO fileDTO);

    @Delete("delete from tbl_board_image where bno=#{bno}")
    int deleteImgs(int pno);
}
