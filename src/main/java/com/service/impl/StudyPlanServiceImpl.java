package com.service.impl;

import com.entity.StudyPlanEntity;
import com.entity.dto.AddStudyPlanReq;
import com.entity.dto.UpdateStudyPlanReq;
import com.mapper.StudyPlanMapper;
import com.service.StudyPlanService;
import com.util.ResponseException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class StudyPlanServiceImpl implements StudyPlanService {
    @Autowired
    private StudyPlanMapper studyPlanMapper;

    @Override
    public void addStudyPlan(AddStudyPlanReq req) {
        val entity = new StudyPlanEntity();
        entity.setPracticeCourse(req.getPracticeCourse());
        entity.setTeachPlan(req.getTeachPlan());
        entity.setTheoryCourse(req.getTheoryCourse());
        entity.setTrainingRoom(req.getTrainingRoom());
        entity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        entity.setApplyTime(datenow);
        studyPlanMapper.addStudyPlan(entity);
    }

    @Override
    public void updateStudyPlan(UpdateStudyPlanReq req) {
        val entity = studyPlanMapper.selectStudyPlanById(req.getId());
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        entity.setPracticeCourse(req.getPracticeCourse());
        entity.setTeachPlan(req.getTeachPlan());
        entity.setTheoryCourse(req.getTheoryCourse());
        entity.setTrainingRoom(req.getTrainingRoom());
        studyPlanMapper.updateStudyPlan(entity);
    }

    @Override
    public void deleteStudyPlan(int id) {
        val entity = studyPlanMapper.selectStudyPlanById(id);
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        studyPlanMapper.deleteStudyPlan(id);
    }

    @Override
    public List<StudyPlanEntity> selectStudyPlan() {
        return studyPlanMapper.selectStudyPlan();
    }
}
