package com.util;

import lombok.Data;

import java.io.File;
import java.util.Map;

@Data
public class WorkflowBean {

	public static final int ZHISHUSCHOOL = 0;
	public static final int QUXIANSCHOOL = 1;
	public static final String SCHOOLTYPE_ZHISHU = "szschool";
	public static final String SCHOOLTYPE_QUXIAN = "qxschool";


	private String uuid;//学校申报信息单ID
	private String taskId;		//任务ID
	private String comment;		//批注
	private String designUser;  //指定的委托用户
	private String startUser;  //流程发起用户
	private String isend; //是否结束
	private String name;  //任务执行人
	private String schoolType; //学校类型



	public WorkflowBean(){

	}

	public WorkflowBean(String taskId, String comment, String schoolType, String designUser, String uuid, String name, String isend){
		if (!taskId.equals("")){
			this.taskId = taskId;
		}
		this.comment = comment;
		
		if (!schoolType.equals("")){
			this.schoolType = schoolType;
		}
		if (!designUser.equals("")){
			this.designUser = designUser;
		}
		if (!uuid.equals("")){
			this.uuid = uuid;
		}
		if (!name.equals("")){
			this.name = name;
		}
		if (!isend.equals("")){
			this.isend = isend;
		}
	}

	public WorkflowBean(String schoolType, String designUser, String uuid){
		if (!schoolType.equals("")){
			this.schoolType = schoolType;
		}
		if (!designUser.equals("")){
			this.designUser = designUser;
		}
		if (!uuid.equals("")){
			this.uuid = uuid;
		}
	}
}
