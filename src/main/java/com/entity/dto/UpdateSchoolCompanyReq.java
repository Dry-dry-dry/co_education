package com.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateSchoolCompanyReq extends AddSchoolCompanyReq {
    @NotNull
    private int id;
}
