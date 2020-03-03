package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddCommonTrainingBaseReq {
    @ApiModelProperty(value = "trainingNum", name = "trainingNum", example = "200")
    private int trainingNum;
    @ApiModelProperty(value = "outNnm", name = "outNnm", example = "200")
    private int outNnm;
    @ApiModelProperty(value = "courseNum", name = "courseNum", example = "200")
    private int courseNum;
    @ApiModelProperty(value = "hourNum", name = "hourNum", example = "200")
    private int hourNum;
    @ApiModelProperty(value = "GS1", name = "GS1", example = "200")
    private int GS1;
    @ApiModelProperty(value = "GS2", name = "GS2", example = "200")
    private int GS2;
    @ApiModelProperty(value = "GS3", name = "GS3", example = "200")
    private int GS3;
    @ApiModelProperty(value = "GS4", name = "GS4", example = "200")
    private int GS4;
    @ApiModelProperty(value = "GS5", name = "GS5", example = "200")
    private int GS5;
    @ApiModelProperty(value = "GS6", name = "GS6", example = "200")
    private int GS6;
}
