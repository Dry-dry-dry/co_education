package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 项目申报
 * */
@Data
public class ApplyProjectEntity {
    private int id;
    private String centreProject;
    private String provincialProject;
    private String cityProject;
    private String localProject;
    private String otherProject;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
