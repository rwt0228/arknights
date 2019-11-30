package com.rwt.arknights.videos.controller;

import com.rwt.arknights.common.bilibili.BiliClient;
import com.rwt.arknights.common.bilibili.VideoInfoDTO;
import com.rwt.arknights.web.bean.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/video")
@RestController
public class VideoController {

    @RequestMapping("/getInfo")
    public JsonResult getInfo(Integer aid) {
        VideoInfoDTO videoInfoDTO = BiliClient.getVideoInfoDTO(aid);
        return JsonResult.OK(videoInfoDTO);
    }
}
