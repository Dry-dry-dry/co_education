package com.service.impl;

import com.entity.StudentConditionEntity;
import com.entity.dto.AddStudentConditionReq;
import com.entity.dto.UpdateStudentConditionReq;
import com.mapper.StudentConditionMapper;
import com.service.StudentConditionService;
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
public class StudentConditionServiceImpl implements StudentConditionService {

    @Resource
    private StudentConditionMapper studentConditionMapper;

    @Override
    public void addStudentCondition(AddStudentConditionReq req) {
        val entity = new StudentConditionEntity();
        entity.setCalssNum(req.getCalssNum());
        entity.setCityWin(req.getCityWin());
        entity.setCountryWin(req.getCountryWin());
        entity.setProvincialWin(req.getProvincialWin());
        entity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        entity.setApplyTime(datenow);
        studentConditionMapper.addStudentCondition(entity);

    }

    @Override
    public void updateStudentCondition(UpdateStudentConditionReq req) {
        val entity = studentConditionMapper.selectStudentConditionById(req.getId());
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        entity.setCalssNum(req.getCalssNum());
        entity.setCityWin(req.getCityWin());
        entity.setCountryWin(req.getCountryWin());
        entity.setProvincialWin(req.getProvincialWin());
        studentConditionMapper.updateStudentCondition(entity);
    }

    @Override
    public void deleteStudentCondition(int id) {
        val entity = studentConditionMapper.selectStudentConditionById(id);
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        studentConditionMapper.deleteStudentCondition(id);
    }

    @Override
    public List<StudentConditionEntity> selectStudentCondition() {
        return studentConditionMapper.selectStudentCondition();
    }
}
