package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddApplyProjectReq {
    @ApiModelProperty(value = "centreProject", name = "centreProject", example = "杭州是")
    private String centreProject;
    @ApiModelProperty(value = "provincialProject", name = "provincialProject", example = "西湖区")
    private String provincialProject;
    @ApiModelProperty(value = "cityProject", name = "cityProject", example = "马成龙")
    private String cityProject;
    @ApiModelProperty(value = "localProject", name = "localProject", example = "北京的故事")
    private String localProject;
    @ApiModelProperty(value = "otherProject", name = "otherProject", example = "北京的故事")
    private String otherProject;
}
