package com.service.impl;

import com.entity.UserEntity;
import com.mapper.UserMapper;
import com.service.ProcessService;
import com.util.Common;
import com.util.WorkflowBean;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ProcessServiceImpl implements ProcessService {

    @Resource
    UserMapper userMapper;

    /**
     * 部署流程定义（从classpath）
     */
    @Override
    public void deploymentProcessDefinition() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署对象相关的Service
                .createDeployment()//创建一个部署对象
                .name("流程定义")//添加部署的名称
                .addClasspathResource("process/eduProcess.bpmn")//从classpath的资源中加载，一次只能加载一个文件
                .addClasspathResource("process/eduProcess.png")//从classpath的资源中加载，一次只能加载一个文件
                .deploy();//完成部署
        System.out.println("部署ID：" + deployment.getId());
        System.out.println("部署名称：" + deployment.getName());
    }


    /**
     * 判断当前数据库中有没有正在运行的流程
     * 如果有，则不允许启动
     * */
    @Override
    @Transactional
    public boolean hasRunningTask(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("eduProcess")
                .list();
        if(taskList != null && taskList.size() > 0){
            return true;
        }
        return false;
    }

    /**
     * 启动流程实例
     * 返回值：流程ID
     * 传入的值：startUser
     */
    @Override
    @Transactional
    public void startProcessInstance(WorkflowBean workflowBean) {

        //查找用户表中区县学校
        List<UserEntity> qxSchools = userMapper.seletUserByRole(Common.ROLE_QXSCHOOL);
        List<UserEntity> qxshUser = userMapper.seletUserByRole(Common.ROLE_QXSHUSER);
        List<UserEntity> sjshUser = userMapper.seletUserByRole(Common.ROLE_SJSHUSER);
        String sjPid = null;
        for(UserEntity user: qxSchools){
            workflowBean = setWorkflowBean(workflowBean,user);
            String pid = startProcess(workflowBean);
            //添加pid 的值到user表的学校用户中
            user.setPid(pid);
            userMapper.updateUser(user);
            //添加pid 的值到user表的区县用户中
            qxshUser.get(0).setPid(pid);
            userMapper.updateUser(qxshUser.get(0));
            //添加pid 的值到user表的市局用户中
            sjPid = pid+ ".szpid";
            sjshUser.get(0).setPid(sjPid);
            userMapper.updateUser(sjshUser.get(0));
        }
        //查找用户表中市直属学校
//        List<UserEntity> szSchools = userMapper.seletUserByRole(Common.ROLE_SZSCHOOL);
//        for(UserEntity user: szSchools){
//            workflowBean = setWorkflowBean(workflowBean,user);
//            String pid = startProcess(workflowBean);
//            //添加pid 的值到user表的学校用户中
//            user.setPid(pid);
//            userMapper.updateUser(user);
//            //添加pid 的值到user表的市局用户中
//            sjPid = sjPid + "\\."+ pid;
//            sjshUser.get(0).setPid(sjPid);
//            userMapper.updateUser(sjshUser.get(0));
//        }
    }

    /**
     * 将UserEntity中的信息组装到WorkflowBean中，方便启动流程
     * */
    public WorkflowBean setWorkflowBean(WorkflowBean workflowBean,UserEntity user){
        workflowBean.setSchoolType(user.getRole());
        workflowBean.setDesignUser(user.getUsername()); //设置流程启动后的任务执行人
        workflowBean.setUuid(String.valueOf(user.getId()));
        return workflowBean;
    }

    /**
     * 启动流程实例具体操作
     * 返回值：流程ID
     * 传入的值：startUser、designUser、uuid、schoolType
     */
    public String startProcess( WorkflowBean workflowBean) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        IdentityService identityService = processEngine.getIdentityService();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //流程定义的key
        String processDefinitionKey = "eduProcess";
        //流程定义
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionKey(processDefinitionKey)
                .latestVersion().singleResult();
        //设置流程发起人，该字段在act_hi_procinst数据表中
        String startUser = workflowBean.getStartUser();
        identityService.setAuthenticatedUserId(startUser);
        //获取流程启动后的任务执行人
        String designUser = workflowBean.getDesignUser();
        //启动流程实例
        String processDefinitionId = processDefinition.getId();
        String applyID = workflowBean.getUuid();
        String businessKey = processDefinitionKey + "." + applyID;

        Map<String, Object> variables = new HashMap<String, Object>();
        //获取schoolType
        if (workflowBean.getSchoolType().equals(WorkflowBean.SCHOOLTYPE_ZHISHU)) {
            variables.put("zsschools", designUser);//表示指定下一任务执行人
            //判断流程变量iszhishu ,如果是市直属学校值为0,不是为1
            variables.put("iszhishu", WorkflowBean.ZHISHUSCHOOL);
            businessKey = businessKey +"."+WorkflowBean.SCHOOLTYPE_ZHISHU;
        } else {
            variables.put("qxschools", designUser);//表示指定下一任务执行人
            //判断流程变量iszhishu ,如果是市直属学校值为0,不是为1
            variables.put("iszhishu", WorkflowBean.QUXIANSCHOOL);
            businessKey = businessKey +"."+WorkflowBean.SCHOOLTYPE_QUXIAN;
        }

        /**
         * 5：	(1)使用流程变量设置字符串（格式：LeaveBill.id的形式），通过设置，让启动的流程（流程实例）关联业务
         * (2)使用正在执行对象表中的一个字段BUSINESS_KEY（Activiti提供的一个字段），让启动的流程（流程实例）关联业务
         * 该字段在act_hi_procinst数据表中
         */
        variables.put("objId", businessKey);

        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinitionId,
                businessKey, variables);
        //获取流程实例ID
        String pid = processInstance.getProcessInstanceId();
        return pid;
    }


    /**
     * 获取Business_key的值，Business_key由流程ID和审批数据单ID组成
     * businessKey = processDefinitionKey + "." + applyID;
     */
    @Override
    public String getBusiness_key(String taskId) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        //1：使用任务ID，查询任务对象Task
        Task task = taskService.createTaskQuery()//
                .taskId(taskId)//使用任务ID查询
                .singleResult();
        //2：使用任务对象Task获取流程实例ID
        String processInstanceId = task.getProcessInstanceId();
        //3：使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
                .processInstanceId(processInstanceId)//使用流程实例ID查询
                .singleResult();

        //4：使用流程实例对象获取BUSINESS_KEY
        String businessKey = pi.getBusinessKey();
        String schooleType = businessKey.split("\\.")[2];
        return pi.getBusinessKey();
    }

    /**
     * 删除流程实例
     * applyID: 审批数据单的ID
     */
    @Override
    public void deleteDeployment(String applyID ,String schoolType) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()
                .processInstanceBusinessKey("eduProcess." + applyID + "."+schoolType)
                .singleResult();
        if (pi != null) {
            runtimeService.deleteProcessInstance(pi.getProcessInstanceId(), null);
        }
    }

    /**
     * 任务完成
     * 需要参数如下：
     * //获取任务ID
     * String taskId = workflowBean.getTaskId();
     * //获取任务指定执行人
     * String designUser = workflowBean.getDesignUser();
     * //判断流程是否结束
     * String isend = workflowBean.getIsend();
     * //获取当前任务执行人
     * String name = workflowBean.getName();
     * //批注信息
     * String message = workflowBean.getComment();
     */
    @Override
    @Transactional
    public void saveSubmitTask(WorkflowBean workflowBean) {
        //处理workflowBean的信息
        workflowBean = dealWorkflowBean(workflowBean);

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        //获取任务ID
        String taskId = workflowBean.getTaskId();
        //批注信息
        String message = workflowBean.getComment();
        //获得和设置任务执行人流程变量
        String designUser = workflowBean.getDesignUser();
        String isend = workflowBean.getIsend();
        //获取当前任务执行人
        String name = workflowBean.getName();

        /**
         * 1：在完成之前，添加一个批注信息，向act_hi_comment表中添加数据，用于记录对当前申请人的一些审核信息
         */
        //使用任务ID，查询任务对象，获取流程流程实例ID
        Task task = taskService.createTaskQuery()//
                .taskId(taskId)//使用任务ID查询
                .singleResult();
        //获取流程实例ID和task任务的executionID
        String processInstanceId = task.getProcessInstanceId();
        String executionId = task.getExecutionId();
//        message = executionId + "." + message; //以executionId.message的形式存储到act.hi.comment表,以方便在子实例获取前后评论

        /**
         * 注意：添加批注的时候，由于Activiti底层代码是使用：
         * 		String userId = Authentication.getAuthenticatedUserId();
         CommentEntity comment = new CommentEntity();
         comment.setUserId(userId);
         所以需要从Session中获取当前登录人，作为该任务的办理人（审核人），对应act_hi_comment表中的User_ID的字段，不过不添加审核人，该字段为null
         所以要求，添加配置执行使用Authentication.setAuthenticatedUserId();添加当前任务的审核人
         * */
        Authentication.setAuthenticatedUserId(name);
        taskService.addComment(taskId, processInstanceId, message);

        String businessKey = getBusiness_key(taskId);
        String schooleType = businessKey.split("\\.")[2];
        if(schooleType.equals(WorkflowBean.SCHOOLTYPE_ZHISHU)){
            if(task.getName().equals("市直属学校")){
                HashMap<String, Object> sjshMap = new HashMap<>();
                sjshMap.put("sjsh", designUser);
                taskService.complete(taskId , sjshMap);

            }else if(task.getName().equals("市局审核")){
                //isend的值 0-同意结束 1-驳回
                if (isend.equals("0")) {
                    taskService.setVariableLocal(taskId, "isend", 0);
                    Map map = new HashMap();
                    map.put("isend",0);
                    taskService.complete(taskId , map);
                } else if (isend.equals("1")) {
                    //注意传的值为1，实际此时流程走2
                    taskService.setVariableLocal(taskId, "isend", 2);
                    HashMap<String, Object> zsschoolsMap = new HashMap<>();
                    zsschoolsMap.put("zsschools", designUser);
                    zsschoolsMap.put("isend", 2);
                    taskService.complete(taskId , zsschoolsMap);
                }
            }
        }else if(schooleType.equals(WorkflowBean.SCHOOLTYPE_QUXIAN)){
            if(task.getName().equals("区县学校")){
                HashMap<String, Object> qxschoolsMap = new HashMap<>();
                qxschoolsMap.put("qxsh", designUser);
                taskService.complete(taskId , qxschoolsMap);

            }else if(task.getName().equals("区县审核")){
                //isend的值 0-同意结束 1-驳回
                if (isend.equals("0")) {
                    taskService.setVariableLocal(taskId, "isend", 0);
                    HashMap<String, Object> sjshMap = new HashMap<>();
                    sjshMap.put("sjsh", designUser);
                    sjshMap.put("isend", 0);
                    taskService.complete(taskId , sjshMap);
                } else if (isend.equals("1")) {
                    taskService.setVariableLocal(taskId, "isend", 1);
                    HashMap<String, Object> qxschoolsMap = new HashMap<>();
                    qxschoolsMap.put("qxschools", designUser);
                    qxschoolsMap.put("isend", 1);
                    taskService.complete(taskId , qxschoolsMap);
                }
            }else if(task.getName().equals("市局审核")){
                //isend的值 0-同意结束 1-驳回
                if (isend.equals("0")) {
                    taskService.setVariableLocal(taskId, "isend", 0);
                    Map map = new HashMap();
                    map.put("isend",0);
                    taskService.complete(taskId, map);
                } else if (isend.equals("1")) {
                    taskService.setVariableLocal(taskId, "isend", 1);
                    HashMap<String, Object> qxshMap = new HashMap<>();
                    qxshMap.put("qxsh", designUser);
                    qxshMap.put("isend",1);
                    taskService.complete(taskId , qxshMap);
                }
            }
        }


        /**
         * 5：在完成任务之后，判断流程是否结束
         如果流程结束了，更新提交的信息表单的状态从1变成2（审核中-->审核完成）
         */
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
                .processInstanceId(processInstanceId)//使用流程实例ID查询
                .singleResult();

        //流程结束了(zhengzhong)
//        if (pi == null) {
//            bill.setStatus(HolidayApply.HAS_CHECK);
//            holidayApplyDao.saveHolidayApply(bill);
//        }
//        //流程驳回到申请人(委派人等于假条申请人),更新请假单表的状态
//        if (isend.equals("2")) {
//            bill.setStatus(HolidayApply.HAS_REJECT);
//            holidayApplyDao.saveHolidayApply(bill);
//        }
    }

    /**
     * 为任务完成处理WorkflowBean
     * 设置name designUser
     */
    @Override
    public WorkflowBean dealWorkflowBean(WorkflowBean workflowBean){
        String userid = workflowBean.getUuid();
        UserEntity userEntity = userMapper.selectUserByID(Integer.parseInt(userid));
        workflowBean.setName(userEntity.getUsername());
        String schoolType = userEntity.getRole();
        String isend = workflowBean.getIsend();
        if(schoolType.equals(Common.ROLE_QXSCHOOL)){
            List<UserEntity> qxshUsers = userMapper.seletUserByRole(Common.ROLE_QXSHUSER);
            workflowBean.setDesignUser(qxshUsers.get(0).getUsername());
        }else if(schoolType.equals(Common.ROLE_SZSCHOOL)){
            List<UserEntity> sjshUsers = userMapper.seletUserByRole(Common.ROLE_SJSHUSER);
            workflowBean.setDesignUser(sjshUsers.get(0).getUsername());
        }else if(schoolType.equals(Common.ROLE_QXSHUSER)){
            if(isend.equals("0")){
                List<UserEntity> sjshUsers = userMapper.seletUserByRole(Common.ROLE_SJSHUSER);
                workflowBean.setDesignUser(sjshUsers.get(0).getUsername());
            }else if(isend.equals("1")){
                List<UserEntity> qxSchools = userMapper.seletUserByRole(Common.ROLE_QXSCHOOL);
                workflowBean.setDesignUser(qxSchools.get(0).getUsername());
            }
        }else if(schoolType.equals(Common.ROLE_SJSHUSER)){
           if(isend.equals("1")){
               String taskId = workflowBean.getTaskId();
               String businessKey = getBusiness_key(taskId);
               String processType = businessKey.split("\\.")[2];
               if(processType.equals(WorkflowBean.SCHOOLTYPE_QUXIAN)){
                   List<UserEntity> qxshUsers = userMapper.seletUserByRole(Common.ROLE_QXSHUSER);
                   workflowBean.setDesignUser(qxshUsers.get(0).getUsername());
               }else if(processType.equals(WorkflowBean.SCHOOLTYPE_ZHISHU)){
                   List<UserEntity> szSchools = userMapper.seletUserByRole(Common.ROLE_SZSCHOOL);
                   workflowBean.setDesignUser(szSchools.get(0).getUsername());
               }
            }
        }
        return workflowBean;
    }

    @Override
    @Transactional
    public String findRunningTask(String username){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();

        List<Task> tasks = taskService.createTaskQuery().
                taskAssignee(username).
                orderByTaskCreateTime().desc().list();
        if(tasks != null && tasks.size()>0){
            //返回taskid
            return tasks.get(0).getId();
        }else {
            return "false";
        }

    }


    /**
     * 根据username 获取流程ID查询流程的批注信息以及当前流程进度
     * */
    @Override
    @Transactional
    public JSONObject findProcessInfoByUsername(String username){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        HistoryService historyService = processEngine.getHistoryService();
        //查询当前用户信息
        UserEntity user = userMapper.selectUserByUsername(username);

//        List<HistoricProcessInstance> hpList = historyService.createHistoricProcessInstanceQuery()
//                .processDefinitionKey("eduprocess").unfinished().list();

        String pid = user.getPid();
        if(user.getRole().equals(Common.ROLE_SJSHUSER)){
            List<String> pidList = new ArrayList<>();
            JSONObject result = new JSONObject();
            pidList.add(pid.split("\\.")[0]); //区县PID
//            pidList.add(pid.split("\\.")[1]); //市直属流程PID
            for (String processId : pidList){
                //查询流程实例判断流程是否结束
                ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
                        .processInstanceId(processId)//使用流程实例ID查询
                        .singleResult();
                if(pi == null){
                    //流程结束
                    JSONObject endProcess = new JSONObject();
                    endProcess.put("流程当前审批人","流程已结束");
                    List<Comment> comments = taskService.getProcessInstanceComments(processId);
                    JSONObject messageJson = new JSONObject();
                    for(Comment comment : comments){
                        String message = comment.getFullMessage();
                        if(message == null){
                            message = "";
                        }
                        String assignee = comment.getUserId();
                        messageJson.put(assignee,message);
                    }
                    endProcess.put("流程批注",messageJson);
                    String processType = historyService.createHistoricProcessInstanceQuery()
                            .processInstanceId(processId).singleResult()
                            .getBusinessKey().split("\\.")[2];
                    result.put(processType , endProcess);
                }else {
                    //根据流程ID查询任务
                    Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult(); // 创建任务查询
                    String processType = historyService.createHistoricProcessInstanceQuery()
                            .processInstanceId(processId).singleResult()
                            .getBusinessKey().split("\\.")[2];
                    result.put(processType,findProcessInfo(task.getId()));
                }
            }
            return result;
        }

        String processType = historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(pid).singleResult()
                .getBusinessKey().split("\\.")[2];
        //查询流程实例判断流程是否结束
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
                .processInstanceId(pid)//使用流程实例ID查询
                .singleResult();
        JSONObject jsonObject = new JSONObject();
        if(pi == null){
            //流程结束
//            jsonObject.put("流程当前审批人","流程已结束");
//            return jsonObject;
            //流程结束
            JSONObject endProcess = new JSONObject();
            endProcess.put("流程当前审批人","流程已结束");
            List<Comment> comments = taskService.getProcessInstanceComments(pid);
            JSONObject messageJson = new JSONObject();
            for(Comment comment : comments){
                String message = comment.getFullMessage();
                if(message == null){
                    message = "";
                }
                String assignee = comment.getUserId();
                messageJson.put(assignee,message);
            }
            endProcess.put("流程批注",messageJson);
            jsonObject.put(processType , endProcess);
            return jsonObject;
        }

        //根据流程ID查询任务
        Task task = taskService.createTaskQuery().processInstanceId(pid).singleResult(); // 创建任务查询
        jsonObject.put(processType , findProcessInfo(task.getId()));
        return jsonObject;
    }

    /**
     * 根据任务ID查询流程的批注信息以及当前流程进度(任务未结束)
     * */
    @Override
    public JSONObject findProcessInfo(String taskID){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        HistoryService historyService = processEngine.getHistoryService();
        Task task=taskService.createTaskQuery() // 创建任务查询
                .taskId(taskID) // 根据任务id查询
                .singleResult();
        //获取流程当前审批人
        String taskAssignee = task.getAssignee();
        JSONObject processStatus = new JSONObject();
        processStatus.put("status",task.getName()); //当前审核节点名称
        processStatus.put("user",taskAssignee);  //审核人

        //获取当前流程实例ID
        String processInstanceId = taskService.createTaskQuery().taskId(taskID).singleResult().getProcessInstanceId();
        List<Comment> comments = taskService.getProcessInstanceComments(processInstanceId);
        JSONObject messageJson = new JSONObject();
        for(Comment comment : comments){
            String message = comment.getFullMessage();
            if(message == null){
                message = "";
            }
            String assignee = comment.getUserId();
            messageJson.put(assignee,message);
        }
//        //使用流程实例ID，查询历史人物
//        List<HistoricTaskInstance> htlist = historyService.createHistoricTaskInstanceQuery()
//                .processInstanceId(processInstanceId).list();
//        JSONObject commentsJson = new JSONObject();
//        if(htlist.size() >0 && htlist !=null){
//            for(HistoricTaskInstance ht: htlist){
//                String taskId = ht.getId();
//                String assignee = ht.getAssignee();
//                List<Comment> comments = taskService.getTaskComments(taskId);
//                commentsJson.put(assignee,comments);
//            }
//        }


        JSONObject result = new JSONObject();
        result.put("流程当前审批人", processStatus);
        result.put("流程批注", messageJson);

        return result;
    }


}
