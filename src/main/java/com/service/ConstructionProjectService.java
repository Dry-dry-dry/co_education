package com.service;

import com.entity.ApplyProjectEntity;
import com.entity.PlanProjetEntity;
import com.entity.dto.AddApplyProjectReq;
import com.entity.dto.AddPlanProjetReq;
import com.entity.dto.UpdateApplyProjectReq;
import com.entity.dto.UpdatePlanProjetReq;

import java.util.List;

public interface ConstructionProjectService {
    //项目申报
    List<ApplyProjectEntity> selectApplyProject();
    void deleteApplyProject(int id);
    void addApplyProject(AddApplyProjectReq req);
    void updateApplyProject(UpdateApplyProjectReq req);

    //项目进度
    List<PlanProjetEntity> selectPlanProject();
    void deletePlanProject(int id);
    void addPlanProject(AddPlanProjetReq req);
    void updatePlanProject(UpdatePlanProjetReq req);
}
