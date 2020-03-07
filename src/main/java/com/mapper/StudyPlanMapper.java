package com.mapper;

import com.entity.StudyPlanEntity;


import java.util.List;

public interface StudyPlanMapper {
    //教学计划基本情况
    int addStudyPlan(StudyPlanEntity entity);
    int updateStudyPlan(StudyPlanEntity entity);
    int deleteStudyPlan(int id);
    List<StudyPlanEntity> selectStudyPlan();
    StudyPlanEntity selectStudyPlanById(int id);
}
