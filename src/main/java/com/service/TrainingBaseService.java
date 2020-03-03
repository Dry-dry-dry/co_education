package com.service;

import com.entity.CommonTrainingBaseEntity;
import com.entity.MajorTrainingBaseEntity;
import com.entity.SchoolTrainingBaseEntity;
import com.entity.dto.*;

import java.util.List;

public interface TrainingBaseService {
    //    全校实训基地
    void addSchoolTrainingBase(AddSchoolTrainingBaseReq req);
    void updateSchoolTrainingBase(UpdateSchoolTrainingBaseReq req);
    void deleteSchoolTrainingBase(int id);
    List<SchoolTrainingBaseEntity> selectSchoolTrainingBase();

    //    专业大类实训基地
    void addMajorTrainingBase(AddMajorTrainingBaseReq req);
    void updateMajorTrainingBase(UpdateMajorTrainingBaseReq req);
    void deleteMajorTrainingBase(int id);
    List<MajorTrainingBaseEntity> selectMajorTrainingBase();

    //    公用实训基地
    void addCommonTrainingBase(AddCommonTrainingBaseReq req);
    void updateCommonTrainingBase(UpdateCommonTrainingBaseReq req);
    void deleteCommonTrainingBase(int id);
    List<CommonTrainingBaseEntity> selectCommonTrainingBase();


}
