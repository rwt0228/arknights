package com.rwt.arknights.videos.dto;

import lombok.Data;

import java.util.List;

@Data
public class QueryDTO {

    private int stageId;
    private int minTag; //最低合约等级
    private int isTag;
    private List<Integer> aid;
    private List<Integer> exclude;


}
