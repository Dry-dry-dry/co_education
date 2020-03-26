package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 办学条件
 * */
@Data
public class StudyPlanEntity {
    private int id;
    private String teachPlan;
    private String theoryCourse;
    private String practiceCourse;
    private String trainingRoom;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
