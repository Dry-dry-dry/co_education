package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateStudentConditionReq extends AddStudentConditionReq {
    @NotNull
    private int id;
}
