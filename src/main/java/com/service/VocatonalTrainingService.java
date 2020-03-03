package com.service;

import com.entity.VocatonalTrainingEntity;
import com.entity.dto.AddVocatonalTrainingReq;
import com.entity.dto.UpdateVocatonalTrainingReq;

import java.util.List;

public interface VocatonalTrainingService {
    void addVocatonalTraining(AddVocatonalTrainingReq req);
    void updateSchoolCondition(UpdateVocatonalTrainingReq req);
    void deleteVocatonalTraining(int id);
    List<VocatonalTrainingEntity> selectVocatonalTraining();
}
