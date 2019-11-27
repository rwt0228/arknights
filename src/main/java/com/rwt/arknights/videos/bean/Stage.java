package com.rwt.arknights.videos.bean;

import lombok.Data;

@Data
public class Stage {
    private Integer id;
    private String type;    //0危机合约 1主线 2活动
    private String code;
    private String name;
    private Integer totalTag;
}
