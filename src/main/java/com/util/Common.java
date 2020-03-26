package com.util;

/**
 * 静态常量取值
 */
public class Common {

    //用于UserEntity
    public static final String ROLE_QXSCHOOL = "qxschool"; //区县学校用户
    public static final String ROLE_SZSCHOOL = "szschool"; //市直属学校
    public static final String ROLE_QXSHUSER = "qxshuser"; //区县审核用户
    public static final String ROLE_SJSHUSER = "sjshuser"; //市局管理员用户


    //用于SchoolDeclareInfoEntity
    //流程状态
    public static final String PROCESS_APPLYING = "applying"; //申请中
    public static final String PROCESS_FINISHED = "finished"; //同意,审批完成
    public static final String PROCESS_REJECT = "reject"; //驳回
    //项目进度
    public static final String PROJECT_FINISHED = "finished"; //已完成
    public static final String PROJECT_FINISHING = "finishing"; //正在完成
    public static final String PROJECT_APPLYING = "applying"; //正在申请
}
