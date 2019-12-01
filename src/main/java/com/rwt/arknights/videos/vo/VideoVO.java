package com.rwt.arknights.videos.vo;

import lombok.Data;

import java.util.List;

@Data
public class VideoVO {

    private int aid;
    private String upName;
    private String title;
    private String imgUrl;
    private String desc;
    private String stage;
    private List<OperatorVO> operators;
    private int avgLevel;
    private String minLevel;
    private Double avgStar;
}
