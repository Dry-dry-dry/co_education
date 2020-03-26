package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 职业培训情况
 * */
@Data
public class VocatonalTrainingEntity {
    private int id;
    private int trainStaff;
    private int seniorNum;
    private int collegeNum;
    private int disableNum;
    private int unemploymentNum;
    private int farmerNum;
    private int rankerNum;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
