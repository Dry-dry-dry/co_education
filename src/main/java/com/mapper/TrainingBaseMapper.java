package com.mapper;

import com.entity.CommonTrainingBaseEntity;
import com.entity.MajorTrainingBaseEntity;
import com.entity.SchoolTrainingBaseEntity;

import java.util.List;

public interface TrainingBaseMapper {
    //    全校实训基地
    int addSchoolTrainingBase(SchoolTrainingBaseEntity entity);
    int updateSchoolTrainingBase(SchoolTrainingBaseEntity entity);
    int deleteSchoolTrainingBase(int id);
    List<SchoolTrainingBaseEntity> selectSchoolTrainingBase();
    SchoolTrainingBaseEntity selectSchoolTrainingBaseById(int id);

    //    专业大类实训基地
    int addMajorTrainingBase(MajorTrainingBaseEntity entity);
    int updateMajorTrainingBase(MajorTrainingBaseEntity entity);
    int deleteMajorTrainingBase(int id);
    List<MajorTrainingBaseEntity> selectMajorTrainingBase();
    MajorTrainingBaseEntity selectMajorTrainingBaseById(int id);

    //    公用实训基地
    int addCommonTrainingBase(CommonTrainingBaseEntity entity);
    int updateCommonTrainingBase(CommonTrainingBaseEntity entity);
    int deleteCommonTrainingBase(int id);
    List<CommonTrainingBaseEntity> selectCommonTrainingBase();
    CommonTrainingBaseEntity selectCommonTrainingBaseById(int id);
}
