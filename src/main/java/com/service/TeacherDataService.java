package com.service;

import com.entity.CommonTeacherEntity;
import com.entity.CompanyTeacherEntity;
import com.entity.TeacherInfoEntity;
import com.entity.dto.*;

import java.util.List;

public interface TeacherDataService {
    //教师基本情况
    void addTeacherInfo(AddTeacherInfoReq req);
    void updateTeacherInfo(UpdateTeacherInfoReq req);
    void deleteTeacherInfo(int id);
    List<TeacherInfoEntity> selectTeacherInfo();

    //公共课教师情况
    void addCommonTeacher(AddCommonTeacherReq req);
    void updateCommonTeacher(UpdateCommonTeacherReq req);
    void deleteCommonTeacher(int id);
    List<CommonTeacherEntity> selectCommonTeacher();

    //公专业大类教师情况
    void addCompanyTeacher(AddCompanyTeacherReq req);
    void updateCompanyTeacher(UpdateCompanyTeacherReq req);
    void deleteCompanyTeacher(int id);
    List<CompanyTeacherEntity> selectCompanyTeacher();


}
