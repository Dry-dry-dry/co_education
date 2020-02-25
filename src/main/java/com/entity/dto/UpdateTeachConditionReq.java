package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTeachConditionReq extends AddTeachConditionReq {
    @NotNull
    private int id;
}
