package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 办学条件
 */
@Data
public class SchoolConditionEntity {
    private int id;
    private int diningSeats;
    private int bookNum;
    private int readSeats;
    private int computerNum;
    private int totalDebt;
    private int teachMachineMoney;
    private int teachMachineNum;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
