package com.service.impl;

import com.entity.*;
import com.entity.dto.*;
import com.mapper.SchoolInfoMapper;
import com.service.SchoolInfoService;
import com.util.ResponseException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SchoolInfoServiceImpl implements SchoolInfoService {

    @Resource
    private SchoolInfoMapper schoolInfoMapper;

    @Override
    public List<SchoolConditionEntity> selectSchoolCondition() {
        return schoolInfoMapper.selectSchoolCondition();
    }

    @Override
    public void deleteSchoolCondition(int id) {
        val schoolConditionEntityById = schoolInfoMapper.selectSchoolConditionById(id);
        if(schoolConditionEntityById==null){
            throw new ResponseException("不合法的id");
        }
        schoolInfoMapper.deleteSchoolCondition(id);
    }

    @Override
    public void addSchoolCondition(AddSchoolConditionReq req) {
        val schoolConditionEntity = new SchoolConditionEntity();
        schoolConditionEntity.setBookNum(req.getBookNum());
        schoolConditionEntity.setComputerNum(req.getComputerNum());
        schoolConditionEntity.setDiningSeats(req.getDiningSeats());
        schoolConditionEntity.setReadSeats(req.getReadSeats());
        schoolConditionEntity.setTeachMachineMoney(req.getTeachMachineMoney());
        schoolConditionEntity.setTeachMachineNum(req.getTeachMachineNum());
        schoolConditionEntity.setTotalDebt(req.getTotalDebt());
        schoolConditionEntity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        schoolConditionEntity.setApplyTime(datenow);
        schoolInfoMapper.addSchoolCondition(schoolConditionEntity);
    }

    @Override
    public synchronized void updateSchoolCondition(UpdateSchoolConditionReq req) {
        val entity = schoolInfoMapper.selectSchoolConditionById(req.getId());
        if (entity==null){
            throw new ResponseException("不合法的id");
        }

        entity.setTotalDebt(req.getTotalDebt());
        entity.setTeachMachineNum(req.getTeachMachineNum());
        entity.setTeachMachineMoney(req.getTeachMachineMoney());
        entity.setReadSeats(req.getReadSeats());
        entity.setDiningSeats(req.getDiningSeats());
        entity.setComputerNum(req.getComputerNum());
        entity.setBookNum(req.getBookNum());

        schoolInfoMapper.updateSchoolCondition(entity);
    }

    @Override
    public void addMajorCorse(AddMajorCorserReq req) {
        val entity = new MajorCorseEntity();
        entity.setMajorCourseNum(req.getMajorCourseNum());
        entity.setMajorDirNum(req.getMajorDirNum());
        entity.setMajorNum(req.getMajorNum());
        entity.setTextbookNum(req.getTextbookNum());
        entity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        entity.setApplyTime(datenow);
        schoolInfoMapper.addMajorCorse(entity);
    }

    @Override
    public void updateMajorCorse(UpdateMajorCorserReq req) {
        val entity = schoolInfoMapper.selecteMajorCorseById(req.getId());
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        entity.setTextbookNum(req.getTextbookNum());
        entity.setMajorNum(req.getMajorNum());
        entity.setMajorDirNum(req.getMajorDirNum());
        entity.setMajorCourseNum(req.getMajorCourseNum());
        schoolInfoMapper.updateMajorCorse(entity);
    }

    @Override
    public void deleteMajorCorse(int id) {
        val entity = schoolInfoMapper.selecteMajorCorseById(id);
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        schoolInfoMapper.deleteMajorCorse(id);
    }

    @Override
    public List<MajorCorseEntity> selectMajorCorse() {
        return schoolInfoMapper.selectMajorCorse();
    }

    @Override
    public void addTeachCondition(AddTeachConditionReq req) {
        val entity = new TeachConditionEntity();
        entity.setTeachCompany(req.getTeachCompany());
        entity.setTeachNum(req.getTeachNum());
        entity.setTeachProfessional(req.getTeachProfessional());
        entity.setTeachSchool(req.getTeachSchool());
        entity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        entity.setApplyTime(datenow);
        schoolInfoMapper.addTeachCondition(entity);
    }

    @Override
    public void updateTeachCondition(UpdateTeachConditionReq req) {
        val entity = schoolInfoMapper.selectTeachConditionById(req.getId());
        if(entity==null){
            throw new ResponseException("不合法的id");
        }

        entity.setTeachCompany(req.getTeachCompany());
        entity.setTeachNum(req.getTeachNum());
        entity.setTeachProfessional(req.getTeachProfessional());
        entity.setTeachSchool(req.getTeachSchool());
        schoolInfoMapper.updateTeachCondition(entity);

    }

    @Override
    public void deleteTeachCondition(int id) {
        val entity = schoolInfoMapper.selectTeachConditionById(id);
        if(entity==null){
            throw new ResponseException("不合法的id");
        }
        schoolInfoMapper.deleteTeachCondition(id);
    }

    @Override
    public List<TeachConditionEntity> selectTeachCondition() {
        return schoolInfoMapper.selectTeachCondition();
    }

    @Override
    public void addColInternational(AddColInternationalReq req) {
        val entity = new ColInternationalEntity();
        entity.setAbordCourse(req.getAbordCourse());
        entity.setAbordTeach(req.getAbordTeach());
        entity.setCoProfess(req.getCoProfess());
        entity.setCorSchool(req.getCorSchool());
        entity.setGoAbroad(req.getGoAbroad());
        entity.setReceiveForgin(req.getReceiveForgin());
        entity.setTrainStudent(req.getTrainStudent());
        entity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        entity.setApplyTime(datenow);
        schoolInfoMapper.addColInternational(entity);
    }

    @Override
    public void updateColInternational(UpdateColInternationalReq req) {
        val entity = schoolInfoMapper.selectColInternationalById(req.getId());
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        entity.setAbordCourse(req.getAbordCourse());
        entity.setAbordTeach(req.getAbordTeach());
        entity.setCoProfess(req.getCoProfess());
        entity.setCorSchool(req.getCorSchool());
        entity.setGoAbroad(req.getGoAbroad());
        entity.setReceiveForgin(req.getReceiveForgin());
        entity.setTrainStudent(req.getTrainStudent());
        schoolInfoMapper.updateColInternational(entity);

    }

    @Override
    public void deleteColInternational(int id) {
        val entity = schoolInfoMapper.selectColInternationalById(id);
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        schoolInfoMapper.deleteColInternational(id);
    }

    @Override
    public List<ColInternationalEntity> selectColInternational() {
        return schoolInfoMapper.selectColInternational();
    }

    @Override
    public void addSchoolCompany(AddSchoolCompanyReq req) {
        val entity = new SchoolCompanyEntity();
        entity.setCompanyNum(req.getCompanyNum());
        entity.setHourNum(req.getHourNum());
        entity.setMajorNum(req.getMajorNum());
        entity.setTeacherNum(req.getTeacherNum());
        entity.setTotalFacility(req.getTotalFacility());
        entity.setTotalMoney(req.getTotalMoney());
        entity.setTrainingBase(req.getTrainingBase());
        entity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        entity.setApplyTime(datenow);
        schoolInfoMapper.addSchoolCompany(entity);
    }

    @Override
    public void updateSchoolCompany(UpdateSchoolCompanyReq req) {
        val entity = schoolInfoMapper.selectSchoolCompanyById(req.getId());
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        entity.setCompanyNum(req.getCompanyNum());
        entity.setHourNum(req.getHourNum());
        entity.setMajorNum(req.getMajorNum());
        entity.setTeacherNum(req.getTeacherNum());
        entity.setTotalFacility(req.getTotalFacility());
        entity.setTotalMoney(req.getTotalMoney());
        entity.setTrainingBase(req.getTrainingBase());
        schoolInfoMapper.updateSchoolCompany(entity);
    }

    @Override
    public void deleteSchoolCompany(int id) {
        val entity = schoolInfoMapper.selectSchoolCompanyById(id);
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        schoolInfoMapper.deleteSchoolCompany(id);
    }

    @Override
    public List<SchoolCompanyEntity> selectSchoolCompany() {
        return schoolInfoMapper.selectSchoolCompany();
    }
}
