package com.rwt.arknights.videos.service;

import com.rwt.arknights.videos.bean.Stage;
import com.rwt.arknights.videos.bean.StageType;
import com.rwt.arknights.videos.dao.StageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class StageService {

    @Autowired
    private StageMapper stageMapper;

    public List<StageType> selectAllType(){
        return stageMapper.selectAllType();
    }

    public List<Stage> selectAllStageByType(Integer typeId) {
        return stageMapper.selectAllStageByType(typeId);
    }
}
