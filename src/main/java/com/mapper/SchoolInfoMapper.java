package com.mapper;

import com.entity.SchoolConditionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchoolInfoMapper {
    List<SchoolConditionEntity> selectSchoolCondition();
    int deleteSchoolCondition(int id);
    SchoolConditionEntity selectSchoolConditionById(int id);
    int addSchoolCondition(SchoolConditionEntity entity);
    int updateSchoolCondition(SchoolConditionEntity entity);
}
