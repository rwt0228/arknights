package com.rwt.arknights.videos.dao;

import com.rwt.arknights.videos.bean.Video;
import com.rwt.arknights.videos.dto.QueryDTO;
import com.rwt.arknights.videos.vo.VideoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VideoMapper {

    int save(Video video);

    Video selectByAid(int aid);

    List<Integer> selectPageId(@Param("dto") QueryDTO dto);
}
