package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddSchoolTrainingBaseReq {
    @ApiModelProperty(value = "trainingRoom", name = "trainingRoom", example = "200")
    private int trainingRoom;
    @ApiModelProperty(value = "equipmentNum", name = "equipmentNum", example = "200")
    private int equipmentNum;
    @ApiModelProperty(value = "station", name = "station", example = "200")
    private int station;
    @ApiModelProperty(value = "money", name = "money", example = "200")
    private int money;
    @ApiModelProperty(value = "schoolID", name = "schoolID", example = "1")
    private int schoolID;
}
