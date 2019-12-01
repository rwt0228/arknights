package com.rwt.arknights.videos.dto;

import lombok.Data;

import java.util.List;

@Data
public class QueryDTO {

    private int stageId;
    private int minTag; //最低合约等级
    private boolean isTag; //最低合约等级
    private List<Integer> aid;
    private List<Integer> exclude;
    private int pageNo;


}
