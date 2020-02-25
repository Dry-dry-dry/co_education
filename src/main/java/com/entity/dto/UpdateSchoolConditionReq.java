package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateSchoolConditionReq extends AddSchoolConditionReq {
    @NotNull
    private int id;
}
