package com.entity.dto;

import com.entity.dto.AddCompanyTeacherReq;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateCompanyTeacherReq extends AddCompanyTeacherReq {
    @NotNull
    private int id;
}
