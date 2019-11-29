package com.rwt.arknights.videos.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Stage {
    private Integer id;
    private String type;    //0危机合约 1主线 2活动
    private String code;
    private Boolean isTag;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;
}
