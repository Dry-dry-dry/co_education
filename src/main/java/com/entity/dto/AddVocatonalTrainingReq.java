package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddVocatonalTrainingReq {
    @ApiModelProperty(value = "trainStaff", name = "trainStaff", example = "200")
    private int trainStaff;
    @ApiModelProperty(value = "seniorNum", name = "seniorNum", example = "200")
    private int seniorNum;
    @ApiModelProperty(value = "collegeNum", name = "collegeNum", example = "200")
    private int collegeNum;
    @ApiModelProperty(value = "disableNum", name = "disableNum", example = "200")
    private int disableNum;
    @ApiModelProperty(value = "unemploymentNum", name = "unemploymentNum", example = "200")
    private int unemploymentNum;
    @ApiModelProperty(value = "farmerNum", name = "farmerNum", example = "200")
    private int farmerNum;
    @ApiModelProperty(value = "rankerNum", name = "rankerNum", example = "200")
    private int rankerNum;
    @ApiModelProperty(value = "schoolID", name = "schoolID", example = "1")
    private int schoolID;
}
