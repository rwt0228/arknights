package com.rwt.arknights.back.controller;

import com.rwt.arknights.videos.service.OperatorService;
import com.rwt.arknights.web.bean.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private OperatorService operatorService;

    @RequestMapping("/operator/list")
    @ResponseBody
    public PageBean operatorList() {
        return new PageBean(operatorService.selectAll());
    }
}
