package com.controller;

import com.entity.*;
import com.entity.dto.*;
import com.service.SchoolInfoService;
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
@RequestMapping(value = "/api/schoolinfo/")
@Api(description = "学校基本情况")
public class SchoolInfoController {

    @Autowired
    private SchoolInfoService schoolInfoService;

    @ApiOperation(value = "查询办学条件信息")
    @GetMapping("/school/selectSchoolCondition")
    public Response<List<SchoolConditionEntity>> selectSchoolCondition() {
        return Response.ok(schoolInfoService.selectSchoolCondition());
    }

    @ApiOperation(value = "删除办学条件信息")
    @DeleteMapping("/school/deleteSchoolCondition/{id}")
    public Response deleteSchoolCondition(@PathVariable("id") @Valid @NotNull int id) {
        schoolInfoService.deleteSchoolCondition(id);
        return Response.ok();
    }

    @ApiOperation(value = "增加办学条件信息")
    @PostMapping("/school/addSchoolCondition")
    public Response addSchoolCondition(@RequestBody @Valid AddSchoolConditionReq req) {
        schoolInfoService.addSchoolCondition(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改办学条件信息")
    @PutMapping("/school/updateSchoolCondition")
    public Response updateSchoolCondition(@RequestBody @Valid UpdateSchoolConditionReq req) {
        schoolInfoService.updateSchoolCondition(req);
        return Response.ok();
    }


    @ApiOperation(value = "增加专业与课程建设")
    @PostMapping("/school/addMajorCorse")
    public Response addMajorCorse(@RequestBody @Valid AddMajorCorserReq req) {
        schoolInfoService.addMajorCorse(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改专业与课程建设")
    @PutMapping("/school/updateMajorCorse")
    public Response updateMajorCorse(@RequestBody @Valid UpdateMajorCorserReq req) {
        schoolInfoService.updateMajorCorse(req);
        return Response.ok();
    }

    @ApiOperation(value = "删除专业与课程建设")
    @DeleteMapping("/school/deleteMajorCorse/{id}")
    public Response deleteMajorCorse(@PathVariable("id") @Valid @NotNull int id) {
        schoolInfoService.deleteMajorCorse(id);
        return Response.ok();
    }

    @ApiOperation(value = "查询专业与课程建设")
    @GetMapping("/school/selectMajorCorse")
    public Response<List<MajorCorseEntity>> selectMajorCorse() {
        return Response.ok(schoolInfoService.selectMajorCorse());
    }

    @ApiOperation(value = "增加参与职教集团情况")
    @PostMapping("/school/addTeachCondition")
    public Response addTeachCondition(@RequestBody @Valid AddTeachConditionReq req) {
        schoolInfoService.addTeachCondition(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改参与职教集团情况")
    @PutMapping("/school/updateTeachCondition")
    public Response updateTeachCondition(@RequestBody @Valid UpdateTeachConditionReq req) {
        schoolInfoService.updateTeachCondition(req);
        return Response.ok();
    }

    @ApiOperation(value = "删除参与职教集团情况")
    @DeleteMapping("/school/deleteTeachCondition/{id}")
    public Response deleteTeachCondition(@PathVariable("id") @Valid @NotNull int id) {
        schoolInfoService.deleteTeachCondition(id);
        return Response.ok();
    }

    @ApiOperation(value = "查询参与职教集团情况")
    @GetMapping("/school/selectTeachCondition")
    public Response<List<TeachConditionEntity>> selectTeachCondition() {
        return Response.ok(schoolInfoService.selectTeachCondition());
    }

    @ApiOperation(value = "增加国际合作")
    @PostMapping("/school/addColInternational")
    public Response addColInternational(@RequestBody @Valid AddColInternationalReq req) {
        schoolInfoService.addColInternational(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改国际合作")
    @PutMapping("/school/updateColInternational")
    public Response updateColInternational(@RequestBody @Valid UpdateColInternationalReq req) {
        schoolInfoService.updateColInternational(req);
        return Response.ok();
    }

    @ApiOperation(value = "删除国际合作")
    @DeleteMapping("/school/deleteColInternational/{id}")
    public Response deleteColInternational(@PathVariable("id") @Valid @NotNull int id) {
        schoolInfoService.deleteColInternational(id);
        return Response.ok();
    }

    @ApiOperation(value = "查询国际合作")
    @GetMapping("/school/selectColInternational")
    public Response<List<ColInternationalEntity>> selectColInternational() {
        return Response.ok(schoolInfoService.selectColInternational());
    }

    @ApiOperation(value = "增加校企合作")
    @PostMapping("/school/addSchoolCompany")
    public Response addSchoolCompany(@RequestBody @Valid AddSchoolCompanyReq req) {
        schoolInfoService.addSchoolCompany(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改校企合作")
    @PutMapping("/school/updateSchoolCompany")
    public Response updateSchoolCompany(@RequestBody @Valid UpdateSchoolCompanyReq req) {
        schoolInfoService.updateSchoolCompany(req);
        return Response.ok();
    }

    @ApiOperation(value = "删除校企合作")
    @DeleteMapping("/school/deleteSchoolCompany/{id}")
    public Response deleteSchoolCompany(@PathVariable("id") @Valid @NotNull int id) {
        schoolInfoService.deleteSchoolCompany(id);
        return Response.ok();
    }

    @ApiOperation(value = "查询校企合作")
    @GetMapping("/school/selectSchoolCompany")
    public Response<List<SchoolCompanyEntity>> selectSchoolCompany() {
        return Response.ok(schoolInfoService.selectSchoolCompany());
    }

}
