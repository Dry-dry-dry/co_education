package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateVocatonalTrainingReq extends AddVocatonalTrainingReq {
    @NotNull
    private int id;
}
