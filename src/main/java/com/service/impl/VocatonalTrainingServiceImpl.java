package com.service.impl;

import com.entity.VocatonalTrainingEntity;
import com.entity.dto.AddVocatonalTrainingReq;
import com.entity.dto.UpdateVocatonalTrainingReq;
import com.mapper.VocatonalTrainingMapper;
import com.service.VocatonalTrainingService;
import com.util.ResponseException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class VocatonalTrainingServiceImpl implements VocatonalTrainingService {

    @Autowired
    private VocatonalTrainingMapper vocatonalTrainingMapper;

    @Override
    public void addVocatonalTraining(AddVocatonalTrainingReq req) {
        val entity = new VocatonalTrainingEntity();
        entity.setCollegeNum(req.getCollegeNum());
        entity.setDisableNum(req.getDisableNum());
        entity.setFarmerNum(req.getFarmerNum());
        entity.setRankerNum(req.getRankerNum());
        entity.setSeniorNum(req.getSeniorNum());
        entity.setTrainStaff(req.getTrainStaff());
        entity.setUnemploymentNum(req.getUnemploymentNum());
        entity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        entity.setApplyTime(datenow);
        vocatonalTrainingMapper.addVocatonalTraining(entity);

    }

    @Override
    public void updateSchoolCondition(UpdateVocatonalTrainingReq req) {
        val entity = vocatonalTrainingMapper.selectVocatonalTrainingById(req.getId());
        if (entity==null){
            throw new ResponseException("不合法的id");
        }

        entity.setCollegeNum(req.getCollegeNum());
        entity.setDisableNum(req.getDisableNum());
        entity.setFarmerNum(req.getFarmerNum());
        entity.setRankerNum(req.getRankerNum());
        entity.setSeniorNum(req.getSeniorNum());
        entity.setTrainStaff(req.getTrainStaff());
        entity.setUnemploymentNum(req.getUnemploymentNum());
        vocatonalTrainingMapper.updateVocatonalTraining(entity);

    }

    @Override
    public void deleteVocatonalTraining(int id) {
        val entity = vocatonalTrainingMapper.selectVocatonalTrainingById(id);
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        vocatonalTrainingMapper.deleteVocatonalTraining(id);
    }

    @Override
    public List<VocatonalTrainingEntity> selectVocatonalTraining() {
        return vocatonalTrainingMapper.selectVocatonalTraining();
    }
}
