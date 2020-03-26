package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 专业与课程建设
 * */
@Data
public class MajorCorseEntity {
    private int id;
    private int majorNum;
    private int majorDirNum;
    private int majorCourseNum;
    private int textbookNum;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
