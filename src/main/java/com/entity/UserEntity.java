package com.entity;

import lombok.Data;

/**
 * 用户类,用于登录
 */
@Data
public class UserEntity {


    private int id; //用户ID ，用于自增和查询 ，如果是学校用户则用于学校标识符schoolID

    private String username;  //用户名,用于登录

    private String password;  //密码 ，登录

    private String role;  //用户角色，区分区县学校用户、区县审核用户，市直属学校用户 和 市局审核用户

    private String pid;  //流程实例ID
}
