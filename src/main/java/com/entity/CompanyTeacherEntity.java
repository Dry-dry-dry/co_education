package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 专业大类教师情况
 * */
@Data
public class CompanyTeacherEntity {
    private int id;
    private int undergraduateTeacher;
    private int graduateTeacher;
    private int companyTeacher;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
