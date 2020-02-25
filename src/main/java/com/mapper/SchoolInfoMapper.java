package com.mapper;

import com.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchoolInfoMapper {
    //办学条件
    List<SchoolConditionEntity> selectSchoolCondition();
    int deleteSchoolCondition(int id);
    SchoolConditionEntity selectSchoolConditionById(int id);
    int addSchoolCondition(SchoolConditionEntity entity);
    int updateSchoolCondition(SchoolConditionEntity entity);

    //专业与课程建设
    int addMajorCorse(MajorCorseEntity entity);
    int updateMajorCorse(MajorCorseEntity entity);
    MajorCorseEntity selecteMajorCorseById(int id);
    int deleteMajorCorse(int id);
    List<MajorCorseEntity> selectMajorCorse();

    //参与职教集团情况
    int addTeachCondition(TeachConditionEntity entity);
    int updateTeachCondition(TeachConditionEntity entity);
    TeachConditionEntity selectTeachConditionById(int id);
    int deleteTeachCondition(int id);
    List<TeachConditionEntity> selectTeachCondition();

    //国际合作
    int addColInternational(ColInternationalEntity entity);
    int updateColInternational(ColInternationalEntity entity);
    ColInternationalEntity selectColInternationalById(int id);
    int deleteColInternational(int id);
    List<ColInternationalEntity> selectColInternational();

    //校企合作
    int addSchoolCompany(SchoolCompanyEntity entity);
    int updateSchoolCompany(SchoolCompanyEntity entity);
    SchoolCompanyEntity selectSchoolCompanyById(int id);
    int deleteSchoolCompany(int id);
    List<SchoolCompanyEntity> selectSchoolCompany();
}
