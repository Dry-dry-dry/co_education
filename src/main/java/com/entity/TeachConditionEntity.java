package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 参与职教集团情况
 * */
@Data
public class TeachConditionEntity {
    private int id;
    private int teachCompany;
    private int teachSchool;
    private int teachProfessional;
    private int teachNum;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
