package com.rwt.arknights.back.controller;

import com.rwt.arknights.videos.bean.Operator;
import com.rwt.arknights.videos.bean.Stage;
import com.rwt.arknights.videos.bean.StageType;
import com.rwt.arknights.videos.service.OperatorService;
import com.rwt.arknights.videos.service.StageService;
import com.rwt.arknights.web.bean.JsonResult;
import com.rwt.arknights.web.bean.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private OperatorService operatorService;
    @Autowired
    private StageService stageService;

    @RequestMapping("/operator/list")
    @ResponseBody
    public PageBean operatorList() {
        return new PageBean(operatorService.selectAll());
    }

    @RequestMapping("/operator/save")
    @ResponseBody
    public JsonResult operatorSave(Operator operator) {
        operatorService.save(operator);
        return JsonResult.OK();
    }

    @RequestMapping("/stage/typelist")
    @ResponseBody
    public List getStageTypeList() {
        List<StageType> stageTypes = stageService.selectAllType();
        return stageTypes;
    }

    @RequestMapping("/stage/treedata")
    @ResponseBody
    public Map getStageTreeData() {
        List<StageType> stageTypes = stageService.selectAllType();
        Map<String, List<Stage>> map = new HashMap<>();
        for(StageType t: stageTypes) {
            String description = t.getDescription();
            Integer typeId = t.getTypeId();
            List<Stage> list = stageService.selectAllStageByType(typeId);
            map.put(description, list);
        }
        return map;
    }
}
