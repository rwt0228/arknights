package com.rwt.arknights.videos.dao;

import com.rwt.arknights.videos.bean.Operator;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperatorMapper {
    List<Operator> selectAll();
}
