package com.mapper;

import com.entity.CommonTeacherEntity;
import com.entity.CompanyTeacherEntity;
import com.entity.TeacherInfoEntity;
import com.entity.dto.AddCommonTeacherReq;

import java.util.List;

public interface TeacherDataMapper {
    //学校基本情况
    int addTeacherInfo(TeacherInfoEntity entity);
    int updateTeacherInfo(TeacherInfoEntity entity);
    int deleteTeacherInfo(int id);
    List<TeacherInfoEntity> selectTeacherInfo();
    TeacherInfoEntity selectTeacherInfoById(int id);

    //公共课教师情况
    int addCommonTeacher(CommonTeacherEntity entity);
    int updateCommonTeacher(CommonTeacherEntity entity);
    int deleteCommonTeacher(int id);
    List<CommonTeacherEntity> selectCommonTeacher();
    CommonTeacherEntity selectCommonTeacherById(int id);

    //公专业大类教师情况
    int addCompanyTeacher(CompanyTeacherEntity entity);
    int updateCompanyTeacher(CompanyTeacherEntity entity);
    int deleteCompanyTeacher(int id);
    List<CompanyTeacherEntity> selectCompanyTeacher();
    CompanyTeacherEntity selectCompanyTeacherById(int id);
}
