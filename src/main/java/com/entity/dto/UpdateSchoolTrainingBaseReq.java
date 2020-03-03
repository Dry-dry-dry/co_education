package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateSchoolTrainingBaseReq extends AddSchoolTrainingBaseReq {
    @NotNull
    private int id;
}
