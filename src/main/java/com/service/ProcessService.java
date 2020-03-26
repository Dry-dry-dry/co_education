package com.service;

import com.util.WorkflowBean;
import net.sf.json.JSONObject;

//activiti 工作流接口
public interface ProcessService {

    public void deploymentProcessDefinition();

    public void startProcessInstance(WorkflowBean workflowBean);

    public String getBusiness_key(String taskId);

    public String findRunningTask(String username);

    public WorkflowBean dealWorkflowBean(WorkflowBean workflowBean);

    public void saveSubmitTask(WorkflowBean workflowBean);

    public void deleteDeployment(String applyID ,String schoolType);

    public JSONObject findProcessInfo(String taskID);

    public JSONObject findProcessInfoByUsername(String username);

    public boolean hasRunningTask();

}
