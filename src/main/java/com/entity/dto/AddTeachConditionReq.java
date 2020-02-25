package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddTeachConditionReq {
    @ApiModelProperty(value = "teachCompany", name = "teachCompany", example = "200")
    private int teachCompany;
    @ApiModelProperty(value = "teachSchool", name = "teachSchool", example = "200")
    private int teachSchool;
    @ApiModelProperty(value = "teachProfessional", name = "teachProfessional", example = "200")
    private int teachProfessional;
    @ApiModelProperty(value = "teachNum", name = "teachNum", example = "200")
    private int teachNum;
}
