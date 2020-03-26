package com.entity;


import lombok.Data;

import java.util.Date;

/**
 * 学校申报信息实体类
 */
@Data
public class SchoolDeclareInfoEntity {

    private int applyID; //申请单ID，自增无他用
    private int schoolID; //学校编号,用于关联学校,关联流程

    private int teacherNum; //教师数量
//    private String teacherType; //学校教师的职称：教授，副教授，普通教师

    private int studentNum; //学生数量

    private int courseNum; //学校教授课程的数量
    private String courseType; //学校课程的类型

    private int trainNum; //学校实训基地数量
    private String trainType; //学校实训基地类型：全校，专业大类，公用实训基地

    private int schoolCompanyNum; //校企合作数量
    private int colInternationalNum; //国际合作数量

    private int projectNum; //学校项目数量
    private String projectType; //学校项目类型：
    private String projectPlanStatus; //学校项目进度

    private String processStatus ; //当前申报流程进度

    private Date applyTime;  //申报信息申请时间
    private String strApplyTime; //时间戳 用于转换
}
