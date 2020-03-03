package com.controller;

import com.entity.CommonTrainingBaseEntity;
import com.entity.MajorTrainingBaseEntity;
import com.entity.SchoolTrainingBaseEntity;
import com.entity.dto.*;
import com.service.TrainingBaseService;
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
@RequestMapping(value = "/api/TrainingBase/")
@Api(description = "实训基地")
public class TrainingBaseController {
    @Autowired
    private TrainingBaseService trainingBaseService;

    @ApiOperation(value = "查询全校实训基地")
    @GetMapping("/school/selectSchoolTrainingBase")
    public Response<List<SchoolTrainingBaseEntity>> selectSchoolTrainingBase() {
        return Response.ok(trainingBaseService.selectSchoolTrainingBase());
    }

    @ApiOperation(value = "删除全校实训基地")
    @DeleteMapping("/school/deleteSchoolTrainingBase/{id}")
    public Response deleteSchoolTrainingBase(@PathVariable("id") @Valid @NotNull int id) {
        trainingBaseService.deleteSchoolTrainingBase(id);
        return Response.ok();
    }

    @ApiOperation(value = "增加全校实训基地")
    @PostMapping("/school/addMajorTrainingBase")
    public Response addSchoolTrainingBase(@RequestBody @Valid AddSchoolTrainingBaseReq req) {
        trainingBaseService.addSchoolTrainingBase(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改全校实训基地")
    @PutMapping("/school/updateSchoolTrainingBase")
    public Response updateSchoolTrainingBase(@RequestBody @Valid UpdateSchoolTrainingBaseReq req) {
        trainingBaseService.updateSchoolTrainingBase(req);
        return Response.ok();
    }

    @ApiOperation(value = "查询专业大类实训基地")
    @GetMapping("/major/selectMajorTrainingBase")
    public Response<List<MajorTrainingBaseEntity>> selectMajorTrainingBase() {
        return Response.ok(trainingBaseService.selectMajorTrainingBase());
    }

    @ApiOperation(value = "删除专业大类实训基地")
    @DeleteMapping("/major/deleteMajorTrainingBase/{id}")
    public Response deleteMajorTrainingBase(@PathVariable("id") @Valid @NotNull int id) {
        trainingBaseService.deleteMajorTrainingBase(id);
        return Response.ok();
    }

    @ApiOperation(value = "增加专业大类实训基地")
    @PostMapping("/major/addMajorTrainingBase")
    public Response addMajorTrainingBase(@RequestBody @Valid AddMajorTrainingBaseReq req) {
        trainingBaseService.addMajorTrainingBase(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改专业大类实训基地")
    @PutMapping("/major/updateMajorTrainingBase")
    public Response updateMajorTrainingBase(@RequestBody @Valid UpdateMajorTrainingBaseReq req) {
        trainingBaseService.updateMajorTrainingBase(req);
        return Response.ok();
    }

    @ApiOperation(value = "查询公用实训基地")
    @GetMapping("/common/selectCommonTrainingBase")
    public Response<List<CommonTrainingBaseEntity>> selectCommonTrainingBase() {
        return Response.ok(trainingBaseService.selectCommonTrainingBase());
    }

    @ApiOperation(value = "删除公用实训基地")
    @DeleteMapping("/common/deleteCommonTrainingBase/{id}")
    public Response deleteCommonTrainingBase(@PathVariable("id") @Valid @NotNull int id) {
        trainingBaseService.deleteCommonTrainingBase(id);
        return Response.ok();
    }

    @ApiOperation(value = "增加公用实训基地")
    @PostMapping("/common/addCommonTrainingBase")
    public Response addCommonTrainingBase(@RequestBody @Valid AddCommonTrainingBaseReq req) {
        trainingBaseService.addCommonTrainingBase(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改公用实训基地")
    @PutMapping("/common/updateCommonTrainingBase")
    public Response updateCommonTrainingBase(@RequestBody @Valid UpdateCommonTrainingBaseReq req) {
        trainingBaseService.updateCommonTrainingBase(req);
        return Response.ok();
    }

}
