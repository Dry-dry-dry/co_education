package com.mapper;


import com.entity.VocatonalTrainingEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VocatonalTrainingMapper {
    int addVocatonalTraining(VocatonalTrainingEntity entity);
    int updateVocatonalTraining(VocatonalTrainingEntity entity);
    int deleteVocatonalTraining(int id);
    List<VocatonalTrainingEntity> selectVocatonalTraining();
    VocatonalTrainingEntity selectVocatonalTrainingById(int id);
}
