package com.mapper;

import com.entity.StudentConditionEntity;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface StudentConditionMapper {
    int addStudentCondition(StudentConditionEntity entity);
    int updateStudentCondition(StudentConditionEntity entity);
    int deleteStudentCondition(int id);
    List<StudentConditionEntity> selectStudentCondition();
    StudentConditionEntity selectStudentConditionById(int id);
}
