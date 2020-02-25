package com.service.impl;

import com.entity.SchoolConditionEntity;
import com.entity.dto.AddSchoolConditionReq;
import com.entity.dto.UpdateSchoolConditionReq;
import com.mapper.SchoolInfoMapper;
import com.service.SchoolInfoService;
import com.util.ResponseException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SchoolInfoServiceImpl implements SchoolInfoService {

    @Autowired
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

}
