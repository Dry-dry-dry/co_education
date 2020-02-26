package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTeacherInfoReq extends AddTeacherInfoReq{
    @NotNull
    private int id;
}
