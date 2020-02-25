package com.controller;

import com.entity.SchoolConditionEntity;
import com.entity.dto.AddSchoolConditionReq;
import com.entity.dto.UpdateSchoolConditionReq;
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

    @ApiOperation(value = "添加办学条件信息")
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


}
