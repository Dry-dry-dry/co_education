package com.service;

import com.entity.StudyPlanEntity;
import com.entity.dto.AddStudyPlanReq;
import com.entity.dto.UpdateStudyPlanReq;

import java.util.List;

public interface StudyPlanService {
    //教学计划基本情况
    void addStudyPlan(AddStudyPlanReq req);
    void updateStudyPlan(UpdateStudyPlanReq req);
    void deleteStudyPlan(int id);
    List<StudyPlanEntity> selectStudyPlan();
}
