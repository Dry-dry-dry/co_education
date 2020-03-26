package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 项目进度
 * */
@Data
public class PlanProjetEntity {
    private int id;
    private String centreProject;
    private String provincialProject;
    private String cityProject;
    private String localProject;
    private String otherProject;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
