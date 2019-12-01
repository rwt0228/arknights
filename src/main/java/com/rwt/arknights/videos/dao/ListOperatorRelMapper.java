package com.rwt.arknights.videos.dao;

import com.rwt.arknights.videos.bean.ListOperatorRel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ListOperatorRelMapper {

    int saveList(@Param("list") List<ListOperatorRel> list);
}
