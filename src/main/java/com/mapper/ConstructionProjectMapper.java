package com.mapper;

import com.entity.ApplyProjectEntity;
import com.entity.PlanProjetEntity;

import java.util.List;

public interface ConstructionProjectMapper {
    //项目申报
    List<ApplyProjectEntity> selectApplyProject();
    int deleteApplyProject(int id);
    ApplyProjectEntity selectApplyProjectById(int id);
    int addApplyProject(ApplyProjectEntity entity);
    int updateApplyProject(ApplyProjectEntity entity);

    //项目进度
    List<PlanProjetEntity> selectPlanProject();
    int deletePlanProject(int id);
    PlanProjetEntity selectPlanProjectById(int id);
    int addPlanProject(PlanProjetEntity entity);
    int updatePlanProject(PlanProjetEntity entity);
}
