package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddSchoolCompanyReq {
    @ApiModelProperty(value = "trainingBase", name = "trainingBase", example = "200")
    private int trainingBase;
    @ApiModelProperty(value = "companyNum", name = "companyNum", example = "200")
    private int companyNum;
    @ApiModelProperty(value = "majorNum", name = "majorNum", example = "200")
    private int majorNum;
    @ApiModelProperty(value = "teacherNum", name = "teacherNum", example = "200")
    private int teacherNum;
    @ApiModelProperty(value = "hourNum", name = "hourNum", example = "200")
    private int hourNum;
    @ApiModelProperty(value = "totalMoney", name = "totalMoney", example = "200")
    private int totalMoney;
    @ApiModelProperty(value = "totalFacility", name = "totalFacility", example = "200")
    private int totalFacility;
    @ApiModelProperty(value = "schoolID", name = "schoolID", example = "1")
    private int schoolID;
}
