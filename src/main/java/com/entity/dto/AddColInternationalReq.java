package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddColInternationalReq {
    @ApiModelProperty(value = "coProfess", name = "coProfess", example = "200")
    private int coProfess;
    @ApiModelProperty(value = "trainStudent", name = "trainStudent", example = "200")
    private int trainStudent;
    @ApiModelProperty(value = "receiveForgin", name = "receiveForgin", example = "200")
    private int receiveForgin;
    @ApiModelProperty(value = "goAbroad", name = "goAbroad", example = "200")
    private int goAbroad;
    @ApiModelProperty(value = "abordCourse", name = "abordCourse", example = "200")
    private int abordCourse;
    @ApiModelProperty(value = "abordTeach", name = "abordTeach", example = "200")
    private int abordTeach;
    @ApiModelProperty(value = "corSchool", name = "corSchool", example = "200")
    private int corSchool;
    @ApiModelProperty(value = "schoolID", name = "schoolID", example = "1")
    private int schoolID;
}
