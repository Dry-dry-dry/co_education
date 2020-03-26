package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 公共课教师情况
 * */
@Data
public class CommonTeacherEntity {
    private int id;
    private int chineseTeacher;
    private int mathTeacher;
    private int englishTeacher;
    private int computerTeacher;
    private int undergraduateTeacher;
    private int graduateTeacher;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
