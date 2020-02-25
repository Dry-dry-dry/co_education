package com.service;

import com.entity.*;
import com.entity.dto.*;

import java.util.List;

public interface SchoolInfoService {
    //办学条件
    List<SchoolConditionEntity> selectSchoolCondition();
    void deleteSchoolCondition(int id);
    void addSchoolCondition(AddSchoolConditionReq req);
    void updateSchoolCondition(UpdateSchoolConditionReq req);

    //专业与课程建设
    void addMajorCorse(AddMajorCorserReq req);
    void updateMajorCorse(UpdateMajorCorserReq req);
    void deleteMajorCorse(int id);
    List<MajorCorseEntity> selectMajorCorse();

    //参与职教集团情况
    void addTeachCondition(AddTeachConditionReq Req);
    void updateTeachCondition(UpdateTeachConditionReq req);
    void deleteTeachCondition(int id);
    List<TeachConditionEntity> selectTeachCondition();

    //国际合作
    void addColInternational(AddColInternationalReq req);
    void updateColInternational(UpdateColInternationalReq req);
    void deleteColInternational(int id);
    List<ColInternationalEntity> selectColInternational();

    //校企合作
    void addSchoolCompany(AddSchoolCompanyReq req);
    void updateSchoolCompany(UpdateSchoolCompanyReq req);
    void deleteSchoolCompany(int id);
    List<SchoolCompanyEntity> selectSchoolCompany();
}
