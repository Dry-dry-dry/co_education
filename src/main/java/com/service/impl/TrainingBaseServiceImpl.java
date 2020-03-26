package com.service.impl;

import com.entity.CommonTrainingBaseEntity;
import com.entity.MajorTrainingBaseEntity;
import com.entity.SchoolTrainingBaseEntity;
import com.entity.dto.*;
import com.mapper.TrainingBaseMapper;
import com.service.TrainingBaseService;
import com.util.ResponseException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TrainingBaseServiceImpl implements TrainingBaseService {

    @Autowired
    private TrainingBaseMapper trainingBaseMapper;

    @Override
    public void addSchoolTrainingBase(AddSchoolTrainingBaseReq req) {
        val entity = new SchoolTrainingBaseEntity();
        entity.setEquipmentNum(req.getEquipmentNum());
        entity.setMoney(req.getMoney());
        entity.setStation(req.getStation());
        entity.setTrainingRoom(req.getTrainingRoom());
        entity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        entity.setApplyTime(datenow);
        trainingBaseMapper.addSchoolTrainingBase(entity);
    }

    @Override
    public void updateSchoolTrainingBase(UpdateSchoolTrainingBaseReq req) {
        val entity = trainingBaseMapper.selectSchoolTrainingBaseById(req.getId());
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        entity.setEquipmentNum(req.getEquipmentNum());
        entity.setMoney(req.getMoney());
        entity.setStation(req.getStation());
        entity.setTrainingRoom(req.getTrainingRoom());
        trainingBaseMapper.updateSchoolTrainingBase(entity);
    }

    @Override
    public void deleteSchoolTrainingBase(int id) {
        val entity = trainingBaseMapper.selectSchoolTrainingBaseById(id);
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        trainingBaseMapper.deleteSchoolTrainingBase(id);
    }

    @Override
    public List<SchoolTrainingBaseEntity> selectSchoolTrainingBase() {
        return trainingBaseMapper.selectSchoolTrainingBase();
    }

    @Override
    public void addMajorTrainingBase(AddMajorTrainingBaseReq req) {
        val entity = new MajorTrainingBaseEntity();
        entity.setEquipmentNum(req.getEquipmentNum());
        entity.setMoney(req.getMoney());
        entity.setStation(req.getStation());
        entity.setTrainingRoom(req.getTrainingRoom());
        entity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        entity.setApplyTime(datenow);
        trainingBaseMapper.addMajorTrainingBase(entity);
    }

    @Override
    public void updateMajorTrainingBase(UpdateMajorTrainingBaseReq req) {
        val entity = trainingBaseMapper.selectMajorTrainingBaseById(req.getId());
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        entity.setEquipmentNum(req.getEquipmentNum());
        entity.setMoney(req.getMoney());
        entity.setStation(req.getStation());
        entity.setTrainingRoom(req.getTrainingRoom());
        trainingBaseMapper.updateMajorTrainingBase(entity);
    }

    @Override
    public void deleteMajorTrainingBase(int id) {
        val entity = trainingBaseMapper.selectMajorTrainingBaseById(id);
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        trainingBaseMapper.deleteMajorTrainingBase(id);
    }

    @Override
    public List<MajorTrainingBaseEntity> selectMajorTrainingBase() {
        return trainingBaseMapper.selectMajorTrainingBase();
    }

    @Override
    public void addCommonTrainingBase(AddCommonTrainingBaseReq req) {
        val entity = new CommonTrainingBaseEntity();
        entity.setCourseNum(req.getCourseNum());
        entity.setGS1(req.getGS1());
        entity.setGS2(req.getGS2());
        entity.setGS3(req.getGS3());
        entity.setGS4(req.getGS4());
        entity.setGS5(req.getGS5());
        entity.setGS6(req.getGS6());
        entity.setHourNum(req.getHourNum());
        entity.setOutNnm(req.getOutNnm());
        entity.setTrainingNum(req.getTrainingNum());
        entity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        entity.setApplyTime(datenow);
        trainingBaseMapper.addCommonTrainingBase(entity);
    }

    @Override
    public void updateCommonTrainingBase(UpdateCommonTrainingBaseReq req) {
        val entity = trainingBaseMapper.selectCommonTrainingBaseById(req.getId());
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        entity.setCourseNum(req.getCourseNum());
        entity.setGS1(req.getGS1());
        entity.setGS2(req.getGS2());
        entity.setGS3(req.getGS3());
        entity.setGS4(req.getGS4());
        entity.setGS5(req.getGS5());
        entity.setGS6(req.getGS6());
        entity.setHourNum(req.getHourNum());
        entity.setOutNnm(req.getOutNnm());
        entity.setTrainingNum(req.getTrainingNum());
        trainingBaseMapper.updateCommonTrainingBase(entity);
    }

    @Override
    public void deleteCommonTrainingBase(int id) {
        val entity = trainingBaseMapper.selectCommonTrainingBaseById(id);
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        trainingBaseMapper.deleteCommonTrainingBase(id);
    }

    @Override
    public List<CommonTrainingBaseEntity> selectCommonTrainingBase() {
        return trainingBaseMapper.selectCommonTrainingBase();
    }
}
