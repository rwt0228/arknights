package com.rwt.arknights.videos.dao;

import com.rwt.arknights.videos.bean.VideoListRel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoListRelMapper {

    int save(VideoListRel listRel);

}
