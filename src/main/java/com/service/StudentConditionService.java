package com.service;

import com.entity.StudentConditionEntity;
import com.entity.dto.AddStudentConditionReq;
import com.entity.dto.UpdateStudentConditionReq;

import java.util.List;

public interface StudentConditionService {
    void addStudentCondition(AddStudentConditionReq req);
    void updateStudentCondition(UpdateStudentConditionReq req);
    void deleteStudentCondition(int id);
    List<StudentConditionEntity> selectStudentCondition();
}
