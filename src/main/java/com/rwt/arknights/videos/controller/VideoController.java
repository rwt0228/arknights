package com.rwt.arknights.videos.controller;

import com.rwt.arknights.common.bilibili.BiliClient;
import com.rwt.arknights.common.bilibili.VideoInfoDTO;
import com.rwt.arknights.videos.dto.NewVideoDTO;
import com.rwt.arknights.videos.service.VideoService;
import com.rwt.arknights.web.bean.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/video")
@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("/getInfo")
    public JsonResult getInfo(Integer aid) {
        VideoInfoDTO videoInfoDTO = BiliClient.getVideoInfoDTO(aid);
        return JsonResult.OK(videoInfoDTO);
    }

    @RequestMapping("/save")
    public JsonResult save(@RequestBody NewVideoDTO dto) {
        videoService.saveNewVideo(dto);
        return JsonResult.OK();
    }
}
