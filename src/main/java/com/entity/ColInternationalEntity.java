package com.entity;

import lombok.Data;

import java.util.Date;


/**
 * 国际合作
 * */
@Data
public class ColInternationalEntity {
    private int id;
    private int coProfess;
    private int trainStudent;
    private int receiveForgin;
    private int goAbroad;
    private int abordCourse;
    private int abordTeach;
    private int corSchool;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
