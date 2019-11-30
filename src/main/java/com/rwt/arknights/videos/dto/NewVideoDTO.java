package com.rwt.arknights.videos.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewVideoDTO {

    private int aid;
    private int type;
    private int stageId;
    private int totalTag;
    private List<OperatorInfoDTO> operatorList;

}
