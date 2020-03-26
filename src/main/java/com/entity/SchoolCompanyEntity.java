package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 校企合作
 * */
@Data
public class SchoolCompanyEntity {
    private int id;
    private int trainingBase;
    private int companyNum;
    private int majorNum;
    private int teacherNum;
    private int hourNum;
    private int totalMoney;
    private int totalFacility;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
