package com.service;

import com.entity.SchoolConditionEntity;
import com.entity.dto.AddSchoolConditionReq;
import com.entity.dto.UpdateSchoolConditionReq;

import java.util.List;

public interface SchoolInfoService {
    //查询办学条件
    List<SchoolConditionEntity> selectSchoolCondition();
    //删除办学条件
    void deleteSchoolCondition(int id);
    //添加办学条件
    void addSchoolCondition(AddSchoolConditionReq req);
    //修改办学条件
    void updateSchoolCondition(UpdateSchoolConditionReq req);
}
