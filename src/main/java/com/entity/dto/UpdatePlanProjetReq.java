package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdatePlanProjetReq extends AddPlanProjetReq {
    @NotNull
    private int id;
}
