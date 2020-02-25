package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateColInternationalReq extends AddColInternationalReq {
    @NotNull
    private int id;
}
