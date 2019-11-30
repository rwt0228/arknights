package com.rwt.arknights.videos.bean;

import lombok.Data;

@Data
public class Video {
    private Integer aid;
    private String desc; //描述
    private Integer stageId;
    private String title;    //标题
    private String imgUrl;
    private Integer type;    //1作业2论文3迫害4其他类型
    private String upName;
    private int totalTag;   //危机合约等级
}
