package com.rwt.arknights.videos.controller;

import com.rwt.arknights.common.bilibili.BiliClient;
import com.rwt.arknights.common.bilibili.VideoInfoDTO;
import com.rwt.arknights.log.service.LogService;
import com.rwt.arknights.videos.bean.Video;
import com.rwt.arknights.videos.dto.NewVideoDTO;
import com.rwt.arknights.videos.dto.QueryDTO;
import com.rwt.arknights.videos.service.VideoService;
import com.rwt.arknights.videos.vo.VideoVO;
import com.rwt.arknights.web.bean.JsonResult;
import com.rwt.arknights.web.exceptionHandler.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.alibaba.druid.sql.ast.SQLPartitionValue.Operator.List;

@RequestMapping("/video")
@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;
    @Autowired
    private LogService logService;

    @RequestMapping("/getInfo")
    public JsonResult getInfo(Integer aid) {
        Video old = videoService.selectByAid(aid);
        if(old != null) throw new CustomException("该视频已经有人提交过，请勿重复提交");
        VideoInfoDTO videoInfoDTO = null;
        try{
             videoInfoDTO = BiliClient.getVideoInfoDTO(aid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("查询b站视频信息错误，请确认AV号正确");
        }
        return JsonResult.OK(videoInfoDTO);
    }

    @RequestMapping("/save")
    public JsonResult save(@RequestBody NewVideoDTO dto, HttpServletRequest request) {
        logService.addNewVideo(dto, request);
        videoService.saveNewVideo(dto);
        return JsonResult.OK();
    }

    @RequestMapping("/page")
    public JsonResult page(@RequestBody QueryDTO dto, HttpServletRequest request) {
        logService.addNewQuery(dto, request);
        List<VideoVO> videoVOS = videoService.selectPageVO(dto);
        return JsonResult.OK( videoVOS);
    }
}
