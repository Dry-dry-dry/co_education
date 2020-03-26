package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 专业大类实训基地
 * */
@Data
public class MajorTrainingBaseEntity {
    private int id;
    private int trainingRoom;
    private int equipmentNum;
    private int station;
    private int money;
    private int schoolID; //学校编号
    private Date applyTime; //表单数据填写时间
}
