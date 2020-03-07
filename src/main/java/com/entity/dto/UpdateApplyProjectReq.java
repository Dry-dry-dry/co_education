package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateApplyProjectReq extends AddApplyProjectReq {
    @NotNull
    private int id;
}
