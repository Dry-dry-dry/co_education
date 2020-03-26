package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 教师基本情况
 * */
@Data
public class TeacherInfoEntity {
    private int id;
    private int totalTeacher;
    private int regularTeacher;
    private int foreignTeacher;
    private int maleNum;
    private int femaleNum;
    private int academicNum;
    private int ProfessionalCourseNum;
    private int highProfessionalNum;
    private int subtropicalHighNum;
    private int mediumNum;
    private int primaryNum;
    private int worldRookieNum;
    private int professionalDisciplinesNum;
    private int goodGreenNum;
    private int citySpecialNum;
    private int provincialSuperNum;
    private int doubleNum;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
