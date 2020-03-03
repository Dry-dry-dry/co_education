package com.controller;

import com.entity.VocatonalTrainingEntity;
import com.entity.dto.AddVocatonalTrainingReq;
import com.entity.dto.UpdateVocatonalTrainingReq;
import com.service.VocatonalTrainingService;
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
@RequestMapping(value = "/api/VocatonalTraining/")
@Api(description = "职业培训情况")
public class VocatonalTrainingController {
    @Autowired
    private VocatonalTrainingService vocatonalTrainingService;

    @ApiOperation(value = "查询职业培训情况")
    @GetMapping("/vocatonal/selectVocatonalTraining")
    public Response<List<VocatonalTrainingEntity>> selectVocatonalTraining() {
        return Response.ok(vocatonalTrainingService.selectVocatonalTraining());
    }

    @ApiOperation(value = "删除职业培训情况")
    @DeleteMapping("/vocatonal/deleteVocatonalTraining/{id}")
    public Response deleteVocatonalTraining(@PathVariable("id") @Valid @NotNull int id) {
        vocatonalTrainingService.deleteVocatonalTraining(id);
        return Response.ok();
    }

    @ApiOperation(value = "增加职业培训情况")
    @PostMapping("/vocatonal/addVocatonalTraining")
    public Response addVocatonalTraining(@RequestBody @Valid AddVocatonalTrainingReq req) {
        vocatonalTrainingService.addVocatonalTraining(req);
        return Response.ok();
    }

    @ApiOperation(value = "修改职业培训情况")
    @PutMapping("/vocatonal/updateSchoolCondition")
    public Response updateSchoolCondition(@RequestBody @Valid UpdateVocatonalTrainingReq req) {
        vocatonalTrainingService.updateSchoolCondition(req);
        return Response.ok();
    }



}
