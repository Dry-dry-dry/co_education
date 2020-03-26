package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddMajorCorserReq {
    @ApiModelProperty(value = "majorNum", name = "majorNum", example = "200")
    private int majorNum;
    @ApiModelProperty(value = "majorDirNum", name = "majorDirNum", example = "200")
    private int majorDirNum;
    @ApiModelProperty(value = "majorCourseNum", name = "majorCourseNum", example = "200")
    private int majorCourseNum;
    @ApiModelProperty(value = "textbookNum", name = "textbookNum", example = "200")
    private int textbookNum;
    @ApiModelProperty(value = "schoolID", name = "schoolID", example = "1")
    private int schoolID;
}
