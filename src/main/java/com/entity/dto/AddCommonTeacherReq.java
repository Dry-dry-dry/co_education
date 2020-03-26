package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddCommonTeacherReq {
    @ApiModelProperty(value = "chineseTeacher", name = "chineseTeacher", example = "200")
    private int chineseTeacher;
    @ApiModelProperty(value = "mathTeacher", name = "mathTeacher", example = "200")
    private int mathTeacher;
    @ApiModelProperty(value = "englishTeacher", name = "englishTeacher", example = "200")
    private int englishTeacher;
    @ApiModelProperty(value = "computerTeacher", name = "computerTeacher", example = "200")
    private int computerTeacher;
    @ApiModelProperty(value = "undergraduateTeacher", name = "undergraduateTeacher", example = "200")
    private int undergraduateTeacher;
    @ApiModelProperty(value = "graduateTeacher", name = "graduateTeacher", example = "200")
    private int graduateTeacher;
    @ApiModelProperty(value = "schoolID", name = "schoolID", example = "1")
    private int schoolID;
}
