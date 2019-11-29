package com.rwt.arknights.videos.dao;

import com.rwt.arknights.videos.bean.Stage;
import com.rwt.arknights.videos.bean.StageType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface StageMapper {

    List<StageType> selectAllType();

    List<Stage> selectAllStageByType(Integer typeId);
}
