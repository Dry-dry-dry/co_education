package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateMajorTrainingBaseReq extends AddMajorTrainingBaseReq{
    @NotNull
    private int id;
}
