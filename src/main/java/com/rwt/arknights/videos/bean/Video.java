package com.rwt.arknights.videos.bean;

import lombok.Data;

@Data
public class Video {
    private Integer avId;
    private String description; //描述
    private Integer stageId;
    private String note;    //上传备注
    private String imgUrl;
    private String type;    //1作业2论文3迫害4其他类型

}
