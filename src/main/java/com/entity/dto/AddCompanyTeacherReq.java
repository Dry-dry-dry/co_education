package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddCompanyTeacherReq {
    @ApiModelProperty(value = "undergraduateTeacher", name = "undergraduateTeacher", example = "200")
    private int undergraduateTeacher;
    @ApiModelProperty(value = "graduateTeacher", name = "graduateTeacher", example = "200")
    private int graduateTeacher;
    @ApiModelProperty(value = "companyTeacher", name = "companyTeacher", example = "200")
    private int companyTeacher;
    @ApiModelProperty(value = "schoolID", name = "schoolID", example = "1")
    private int schoolID;
}
