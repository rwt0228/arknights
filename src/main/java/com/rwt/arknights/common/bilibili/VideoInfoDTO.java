package com.rwt.arknights.common.bilibili;

import lombok.Data;

@Data
public class VideoInfoDTO {

    private int aid;
    private String upName;
    private String title;
    private String desc; //视频描述
    private String pic; //封面
}
