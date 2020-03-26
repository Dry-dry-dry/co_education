package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddTeacherInfoReq {
    @ApiModelProperty(value = "totalTeacher", name = "totalTeacher", example = "200")
    private int totalTeacher;
    @ApiModelProperty(value = "regularTeacher", name = "regularTeacher", example = "200")
    private int regularTeacher;
    @ApiModelProperty(value = "foreignTeacher", name = "foreignTeacher", example = "200")
    private int foreignTeacher;
    @ApiModelProperty(value = "maleNum", name = "maleNum", example = "200")
    private int maleNum;
    @ApiModelProperty(value = "femaleNum", name = "femaleNum", example = "200")
    private int femaleNum;
    @ApiModelProperty(value = "academicNum", name = "academicNum", example = "200")
    private int academicNum;
    @ApiModelProperty(value = "ProfessionalCourseNum", name = "ProfessionalCourseNum", example = "200")
    private int ProfessionalCourseNum;
    @ApiModelProperty(value = "highProfessionalNum", name = "highProfessionalNum", example = "200")
    private int highProfessionalNum;
    @ApiModelProperty(value = "subtropicalHighNum", name = "subtropicalHighNum", example = "200")
    private int subtropicalHighNum;
    @ApiModelProperty(value = "mediumNum", name = "mediumNum", example = "200")
    private int mediumNum;
    @ApiModelProperty(value = "primaryNum", name = "primaryNum", example = "200")
    private int primaryNum;
    @ApiModelProperty(value = "worldRookieNum", name = "worldRookieNum", example = "200")
    private int worldRookieNum;
    @ApiModelProperty(value = "professionalDisciplinesNum", name = "professionalDisciplinesNum", example = "200")
    private int professionalDisciplinesNum;
    @ApiModelProperty(value = "goodGreenNum", name = "goodGreenNum", example = "200")
    private int goodGreenNum;
    @ApiModelProperty(value = "citySpecialNum", name = "citySpecialNum", example = "200")
    private int citySpecialNum;
    @ApiModelProperty(value = "provincialSuperNum", name = "provincialSuperNum", example = "200")
    private int provincialSuperNum;
    @ApiModelProperty(value = "doubleNum", name = "doubleNum", example = "200")
    private int doubleNum;
    @ApiModelProperty(value = "schoolID", name = "schoolID", example = "1")
    private int schoolID;

}
