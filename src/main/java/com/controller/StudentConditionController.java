package com.controller;

import com.entity.StudentConditionEntity;
import com.entity.TeacherInfoEntity;
import com.entity.dto.AddStudentConditionReq;
import com.entity.dto.AddTeacherInfoReq;
import com.entity.dto.UpdateStudentConditionReq;
import com.entity.dto.UpdateTeacherInfoReq;
import com.service.StudentConditionService;
import com.service.TeacherDataService;
import com.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "/api/studentcondition/")
@Api(description = "学生基本情况")
public class StudentConditionController {
    @Autowired
    private StudentConditionService studentConditionService;

    @ApiOperation(value = "查询学生基本情况")
    @GetMapping("/student/selectStudentCondition")
    public Response<List<StudentConditionEntity>> selectStudentCondition() {
        return Response.ok(studentConditionService.selectStudentCondition());
    }

    @ApiOperation(value = "删除学生基本情况")
    @DeleteMapping("/student/deleteStudentCondition/{id}")
    public Response deleteStudentCondition(@PathVariable("id") @Valid @NotNull int id) {
        studentConditionService.deleteStudentCondition(id);
        return Response.ok();
    }

    @ApiOperation(value = "增加学生基本情况")
    @PostMapping("/student/addStudentCondition")
    public Response addStudentCondition(@RequestBody @Valid AddStudentConditionReq req) {
        studentConditionService.addStudentCondition(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改学生基本情况")
    @PutMapping("/student/updateStudentCondition")
    public Response updateStudentCondition(@RequestBody @Valid UpdateStudentConditionReq req) {
        studentConditionService.updateStudentCondition(req);
        return Response.ok();
    }
}
