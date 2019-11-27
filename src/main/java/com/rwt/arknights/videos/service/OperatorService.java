package com.rwt.arknights.videos.service;

import com.rwt.arknights.videos.bean.Operator;
import com.rwt.arknights.videos.dao.OperatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OperatorService {

    @Autowired
    private OperatorMapper operatorMapper;

    public List<Operator> selectAll() {
        return operatorMapper.selectAll();
    }
}
