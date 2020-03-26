package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddStudentConditionReq {
    @ApiModelProperty(value = "calssNum", name = "calssNum", example = "200")
    private int calssNum;
    @ApiModelProperty(value = "countryWin", name = "countryWin", example = "200")
    private int countryWin;
    @ApiModelProperty(value = "provincialWin", name = "provincialWin", example = "200")
    private int provincialWin;
    @ApiModelProperty(value = "cityWin", name = "cityWin", example = "200")
    private int cityWin;
    @ApiModelProperty(value = "schoolID", name = "schoolID", example = "1")
    private int schoolID;
}
