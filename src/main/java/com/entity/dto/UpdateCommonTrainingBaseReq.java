package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateCommonTrainingBaseReq extends AddCommonTrainingBaseReq{
    @NotNull
    private int id;
}
