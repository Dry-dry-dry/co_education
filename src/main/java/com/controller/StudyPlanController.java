package com.controller;

import com.entity.StudyPlanEntity;
import com.entity.dto.AddStudyPlanReq;
import com.entity.dto.UpdateStudyPlanReq;
import com.service.StudyPlanService;
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
@RequestMapping(value = "/api/studyplan/")
@Api(description = "教学计划基本情况")
public class StudyPlanController {
    @Autowired
    private StudyPlanService studyPlanService;

    @ApiOperation(value = "查询教学计划基本情况")
    @GetMapping("/study/selectStudyPlan")
    public Response<List<StudyPlanEntity>> selectStudyPlan() {
        return Response.ok(studyPlanService.selectStudyPlan());
    }

    @ApiOperation(value = "删除教学计划基本情况")
    @DeleteMapping("/study/deleteStudyPlan/{id}")
    public Response deleteStudyPlan(@PathVariable("id") @Valid @NotNull int id) {
        studyPlanService.deleteStudyPlan(id);
        return Response.ok();
    }

    @ApiOperation(value = "增加教学计划基本情况")
    @PostMapping("/study/addStudyPlan")
    public Response addStudyPlan(@RequestBody @Valid AddStudyPlanReq req) {
        studyPlanService.addStudyPlan(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改教学计划基本情况")
    @PutMapping("/study/updateStudyPlan")
    public Response updateStudyPlan(@RequestBody @Valid UpdateStudyPlanReq req) {
        studyPlanService.updateStudyPlan(req);
        return Response.ok();
    }

}
