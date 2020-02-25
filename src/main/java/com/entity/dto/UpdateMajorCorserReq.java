package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateMajorCorserReq extends AddMajorCorserReq{
    @NotNull
    private int id;
}
