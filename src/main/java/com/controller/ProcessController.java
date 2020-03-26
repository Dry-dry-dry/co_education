package com.controller;


import com.entity.UserEntity;
import com.service.ProcessService;
import com.util.Response;
import com.util.WorkflowBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "/api/process/")
@Api(description = "流程相关接口")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @ApiOperation(value = "流程部署，仅需要部署一次")
    @GetMapping("/deployment")
    public Response deployment() {
        processService.deploymentProcessDefinition();
        return Response.ok();
    }

    /**
     * 指定市局管理员用户启动流程
     * 流程启动后给各学校用户发出通告
     * 注意：用户表中有几个学校用户就启动几个流程
     * 当前仅支持两个学校用户、一个区县用户、一个市局用户
     * 前端传入字段名  startUser ： 流程发起人
     * */
    @ApiOperation(value = "市局管理员启动审报流程")
    @PostMapping("/startProcess")
    public Response startProcess(@RequestBody WorkflowBean workflowBean) {
        Boolean hasRunningTask = processService.hasRunningTask();
        if(hasRunningTask){
            return Response.error("当前流程有尚未完成的任务，禁止再次启动");
        }
        processService.startProcessInstance(workflowBean);
        return Response.ok();
    }

    /**
     * 查询当前时间能否申报 传值：username
     * 能：进入页面填报信息  返回值taskid
     * 不能：提示不在申报时间内  返回值 false
     * */
    @ApiOperation(value = "学校用户查询能否申报,以及其他用户获取任务ID")
    @PostMapping("/findRunningTask")
    public Response findRunningTask(@RequestBody UserEntity user) {
        String result = processService.findRunningTask(user.getUsername());
        return Response.ok(result);
    }

    /**
     * 参数：username
     *
     * 返回值：流程批注信息，当前流程进度
     * */
    @ApiOperation(value = "流程相关信息查询")
    @PostMapping("/findProcessInfo")
    @ResponseBody
    public Response findProcessInfo(@RequestBody UserEntity user) {
        return Response.ok(processService.findProcessInfoByUsername(user.getUsername()));
    }

    /**
     * 参数：
     * taskId 流程任务ID
     * isend  判断是否结束  0-提交、同意  1-驳回
     * uuid   当前用户id
     * comment 批注信息
     *
     * 返回值:
     * */
    @ApiOperation(value = "任务提交，同意，驳回")
    @PostMapping("/submitTask")
    public Response submitTask(@RequestBody WorkflowBean workflowBean) {
        processService.saveSubmitTask(workflowBean);
        return Response.ok();
    }

}
