package com.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddSchoolConditionReq {
    @ApiModelProperty(value = "diningSeats", name = "diningSeats", example = "200")
    private int diningSeats;
    @ApiModelProperty(value = "bookNum", name = "bookNum", example = "200")
    private int bookNum;
    @ApiModelProperty(value = "readSeats", name = "readSeats", example = "200")
    private int readSeats;
    @ApiModelProperty(value = "computerNum", name = "computerNum", example = "200")
    private int computerNum;
    @ApiModelProperty(value = "totalDebt", name = "totalDebt", example = "200")
    private int totalDebt;
    @ApiModelProperty(value = "teachMachineMoney", name = "teachMachineMoney", example = "200")
    private int teachMachineMoney;
    @ApiModelProperty(value = "teachMachineNum", name = "teachMachineNum", example = "200")
    private int teachMachineNum;


}
