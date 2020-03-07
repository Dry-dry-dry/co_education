package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateStudyPlanReq extends AddStudyPlanReq{
    @NotNull
    private int id;
}
