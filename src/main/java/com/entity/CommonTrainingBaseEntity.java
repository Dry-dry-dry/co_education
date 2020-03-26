package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 公用实训基地
 * */
@Data
public class CommonTrainingBaseEntity {
    private int id;
    private int trainingNum;
    private int outNnm;
    private int courseNum;
    private int hourNum;
    private int GS1;
    private int GS2;
    private int GS3;
    private int GS4;
    private int GS5;
    private int GS6;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
