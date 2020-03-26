package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 学生基本情况
 * */
@Data
public class StudentConditionEntity {
    private int id;
    private int calssNum;
    private int countryWin;
    private int provincialWin;
    private int cityWin;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
