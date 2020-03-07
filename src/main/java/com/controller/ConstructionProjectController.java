package com.controller;

import com.entity.ApplyProjectEntity;
import com.entity.PlanProjetEntity;
import com.entity.SchoolConditionEntity;
import com.entity.dto.*;
import com.service.ConstructionProjectService;
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
@RequestMapping(value = "/api/constructionproject/")
@Api(description = "建设项目管理")
public class ConstructionProjectController {
    @Autowired
    private ConstructionProjectService constructionProjectService;

    @ApiOperation(value = "查询项目申报信息")
    @GetMapping("/applyproject/selectApplyProject")
    public Response<List<ApplyProjectEntity>> selectApplyProject() {
        return Response.ok(constructionProjectService.selectApplyProject());
    }

    @ApiOperation(value = "删除项目申报信息")
    @DeleteMapping("/applyproject/deleteApplyProject/{id}")
    public Response deleteApplyProject(@PathVariable("id") @Valid @NotNull int id) {
        constructionProjectService.deleteApplyProject(id);
        return Response.ok();
    }

    @ApiOperation(value = "增加项目申报信息")
    @PostMapping("/applyproject/addApplyProject")
    public Response addApplyProject(@RequestBody @Valid AddApplyProjectReq req) {
        constructionProjectService.addApplyProject(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改项目申报信息")
    @PutMapping("/applyproject/updateApplyProject")
    public Response updateApplyProject(@RequestBody @Valid UpdateApplyProjectReq req) {
        constructionProjectService.updateApplyProject(req);
        return Response.ok();
    }

    @ApiOperation(value = "查询项目进度信息")
    @GetMapping("/planproject/selectPlanProject")
    public Response<List<PlanProjetEntity>> selectPlanProject() {
        return Response.ok(constructionProjectService.selectPlanProject());
    }

    @ApiOperation(value = "删除项目进度信息")
    @DeleteMapping("/planproject/deletePlanProject/{id}")
    public Response deletePlanProject(@PathVariable("id") @Valid @NotNull int id) {
        constructionProjectService.deletePlanProject(id);
        return Response.ok();
    }

    @ApiOperation(value = "增加项目进度信息")
    @PostMapping("/planproject/addPlanProject")
    public Response addPlanProject(@RequestBody @Valid AddPlanProjetReq req) {
        constructionProjectService.addPlanProject(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改项目进度信息")
    @PutMapping("/planproject/updatePlanProject")
    public Response updatePlanProject(@RequestBody @Valid UpdatePlanProjetReq req) {
        constructionProjectService.updatePlanProject(req);
        return Response.ok();
    }

}
