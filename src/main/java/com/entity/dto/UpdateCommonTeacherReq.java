package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateCommonTeacherReq extends AddCommonTeacherReq {
    @NotNull
    private int id;

}
