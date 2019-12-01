package com.rwt.arknights.videos.dao;

import com.rwt.arknights.videos.bean.Video;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoMapper {

    int save(Video video);

    Video selectByAid(int aid);
}
