package com.controller;

import com.entity.CommonTeacherEntity;
import com.entity.CompanyTeacherEntity;
import com.entity.TeacherInfoEntity;
import com.entity.dto.*;
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
@RequestMapping(value = "/api/teacherdata/")
@Api(description = "教师数据填报")
public class TeacherDataController {

    @Autowired
    private TeacherDataService teacherDataService;

    @ApiOperation(value = "查询教师基本情况")
    @GetMapping("/teacher/selectTeacherInfo")
    public Response<List<TeacherInfoEntity>> selectTeacherInfo() {
        return Response.ok(teacherDataService.selectTeacherInfo());
    }

    @ApiOperation(value = "删除教师基本情况")
    @DeleteMapping("/teacher/deleteTeacherInfo/{id}")
    public Response deleteTeacherInfo(@PathVariable("id") @Valid @NotNull int id) {
        teacherDataService.deleteTeacherInfo(id);
        return Response.ok();
    }

    @ApiOperation(value = "增加教师基本情况")
    @PostMapping("/teacher/addTeacherInfo")
    public Response addTeacherInfo(@RequestBody @Valid AddTeacherInfoReq req) {
        teacherDataService.addTeacherInfo(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改教师基本情况")
    @PutMapping("/teacher/updateTeacherInfo")
    public Response updateTeacherInfo(@RequestBody @Valid UpdateTeacherInfoReq req) {
        teacherDataService.updateTeacherInfo(req);
        return Response.ok();
    }

    @ApiOperation(value = "查询公共课教师情况")
    @GetMapping("/teacher/selectCommonTeacher")
    public Response<List<CommonTeacherEntity>> selectCommonTeacher() {
        return Response.ok(teacherDataService.selectCommonTeacher());
    }

    @ApiOperation(value = "删除公共课教师情况")
    @DeleteMapping("/teacher/deleteCommonTeacher/{id}")
    public Response deleteCommonTeacher(@PathVariable("id") @Valid @NotNull int id) {
        teacherDataService.deleteCommonTeacher(id);
        return Response.ok();
    }

    @ApiOperation(value = "增加公共课教师情况")
    @PostMapping("/teacher/addCommonTeacher")
    public Response addCommonTeacher(@RequestBody @Valid AddCommonTeacherReq req) {
        teacherDataService.addCommonTeacher(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改公共课教师情况")
    @PutMapping("/teacher/updateCommonTeacher")
    public Response updateCommonTeacher(@RequestBody @Valid UpdateCommonTeacherReq req) {
        teacherDataService.updateCommonTeacher(req);
        return Response.ok();
    }

    @ApiOperation(value = "查询公专业大类教师情况")
    @GetMapping("/teacher/selectCompanyTeacher")
    public Response<List<CompanyTeacherEntity>> selectCompanyTeacher() {
        return Response.ok(teacherDataService.selectCompanyTeacher());
    }

    @ApiOperation(value = "删除公专业大类教师情况")
    @DeleteMapping("/teacher/deleteCompanyTeacher/{id}")
    public Response deleteCompanyTeacher(@PathVariable("id") @Valid @NotNull int id) {
        teacherDataService.deleteCompanyTeacher(id);
        return Response.ok();
    }

    @ApiOperation(value = "增加公专业大类教师情况")
    @PostMapping("/teacher/addCompanyTeacher")
    public Response addCompanyTeacher(@RequestBody @Valid AddCompanyTeacherReq req) {
        teacherDataService.addCompanyTeacher(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改公专业大类教师情况")
    @PutMapping("/teacher/updateCompanyTeacher")
    public Response updateCompanyTeacher(@RequestBody @Valid UpdateCompanyTeacherReq req) {
        teacherDataService.updateCompanyTeacher(req);
        return Response.ok();
    }
}
