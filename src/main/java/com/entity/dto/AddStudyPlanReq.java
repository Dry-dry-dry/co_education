package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddStudyPlanReq {
    @ApiModelProperty(value = "teachPlan", name = "teachPlan", example = "这是教学计划")
    private String teachPlan;
    @ApiModelProperty(value = "theoryCourse", name = "theoryCourse", example = "理论课程")
    private String theoryCourse;
    @ApiModelProperty(value = "practiceCourse", name = "practiceCourse", example = "合理lo")
    private String practiceCourse;
    @ApiModelProperty(value = "trainingRoom", name = "trainingRoom", example = "合理lo")
    private String trainingRoom;
}
