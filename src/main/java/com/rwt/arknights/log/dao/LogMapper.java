package com.rwt.arknights.log.dao;

import com.rwt.arknights.log.bean.Log;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    int save(Log log);
}
