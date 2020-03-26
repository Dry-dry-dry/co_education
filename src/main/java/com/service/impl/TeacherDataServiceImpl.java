package com.service.impl;

import com.entity.CommonTeacherEntity;
import com.entity.CompanyTeacherEntity;
import com.entity.TeacherInfoEntity;
import com.entity.dto.*;
import com.mapper.TeacherDataMapper;
import com.service.TeacherDataService;
import com.util.ResponseException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TeacherDataServiceImpl implements TeacherDataService {

    @Autowired
    private TeacherDataMapper teacherDataMapper;

    @Override
    public void addTeacherInfo(AddTeacherInfoReq req) {
        val entity = new TeacherInfoEntity();
        entity.setAcademicNum(req.getAcademicNum());
        entity.setCitySpecialNum(req.getCitySpecialNum());
        entity.setDoubleNum(req.getDoubleNum());
        entity.setFemaleNum(req.getFemaleNum());
        entity.setForeignTeacher(req.getForeignTeacher());
        entity.setGoodGreenNum(req.getGoodGreenNum());
        entity.setHighProfessionalNum(req.getHighProfessionalNum());
        entity.setMaleNum(req.getMaleNum());
        entity.setMediumNum(req.getMediumNum());
        entity.setPrimaryNum(req.getPrimaryNum());
        entity.setProfessionalCourseNum(req.getProfessionalCourseNum());
        entity.setProfessionalDisciplinesNum(req.getProfessionalDisciplinesNum());
        entity.setProvincialSuperNum(req.getProvincialSuperNum());
        entity.setRegularTeacher(req.getRegularTeacher());
        entity.setSubtropicalHighNum(req.getSubtropicalHighNum());
        entity.setTotalTeacher(req.getTotalTeacher());
        entity.setWorldRookieNum(req.getWorldRookieNum());
        entity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        entity.setApplyTime(datenow);
        teacherDataMapper.addTeacherInfo(entity);
    }

    @Override
    public void updateTeacherInfo(UpdateTeacherInfoReq req) {
        val entity = teacherDataMapper.selectTeacherInfoById(req.getId());
        if (entity == null) {
            throw new ResponseException("不合法的id");
        }
        entity.setAcademicNum(req.getAcademicNum());
        entity.setCitySpecialNum(req.getCitySpecialNum());
        entity.setDoubleNum(req.getDoubleNum());
        entity.setFemaleNum(req.getFemaleNum());
        entity.setForeignTeacher(req.getForeignTeacher());
        entity.setGoodGreenNum(req.getGoodGreenNum());
        entity.setHighProfessionalNum(req.getHighProfessionalNum());
        entity.setMaleNum(req.getMaleNum());
        entity.setMediumNum(req.getMediumNum());
        entity.setPrimaryNum(req.getPrimaryNum());
        entity.setProfessionalCourseNum(req.getProfessionalCourseNum());
        entity.setProfessionalDisciplinesNum(req.getProfessionalDisciplinesNum());
        entity.setProvincialSuperNum(req.getProvincialSuperNum());
        entity.setRegularTeacher(req.getRegularTeacher());
        entity.setSubtropicalHighNum(req.getSubtropicalHighNum());
        entity.setTotalTeacher(req.getTotalTeacher());
        entity.setWorldRookieNum(req.getWorldRookieNum());
        teacherDataMapper.updateTeacherInfo(entity);
    }

    @Override
    public void deleteTeacherInfo(int id) {
        val entity = teacherDataMapper.selectTeacherInfoById(id);
        if (entity == null) {
            throw new ResponseException("不合法的id");
        }
        teacherDataMapper.deleteTeacherInfo(id);
    }

    @Override
    public List<TeacherInfoEntity> selectTeacherInfo() {
        return teacherDataMapper.selectTeacherInfo();
    }

    @Override
    public void addCommonTeacher(AddCommonTeacherReq req) {
        val entity = new CommonTeacherEntity();
        entity.setChineseTeacher(req.getChineseTeacher());
        entity.setEnglishTeacher(req.getEnglishTeacher());
        entity.setComputerTeacher(req.getComputerTeacher());
        entity.setGraduateTeacher(req.getGraduateTeacher());
        entity.setMathTeacher(req.getMathTeacher());
        entity.setUndergraduateTeacher(req.getUndergraduateTeacher());
        entity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        entity.setApplyTime(datenow);
        teacherDataMapper.addCommonTeacher(entity);
    }

    @Override
    public void updateCommonTeacher(UpdateCommonTeacherReq req) {
        val entity = teacherDataMapper.selectCommonTeacherById(req.getId());
        if (entity == null) {
            throw new ResponseException("不合法的id");
        }
        entity.setChineseTeacher(req.getChineseTeacher());
        entity.setEnglishTeacher(req.getEnglishTeacher());
        entity.setComputerTeacher(req.getComputerTeacher());
        entity.setGraduateTeacher(req.getGraduateTeacher());
        entity.setMathTeacher(req.getMathTeacher());
        entity.setUndergraduateTeacher(req.getUndergraduateTeacher());
        teacherDataMapper.updateCommonTeacher(entity);
    }

    @Override
    public void deleteCommonTeacher(int id) {
        val entity = teacherDataMapper.selectCommonTeacherById(id);
        if (entity == null) {
            throw new ResponseException("不合法的id");
        }
        teacherDataMapper.deleteCommonTeacher(id);
    }

    @Override
    public List<CommonTeacherEntity> selectCommonTeacher() {
        return teacherDataMapper.selectCommonTeacher();
    }

    @Override
    public void addCompanyTeacher(AddCompanyTeacherReq req) {
        val entity = new CompanyTeacherEntity();
        entity.setCompanyTeacher(req.getCompanyTeacher());
        entity.setGraduateTeacher(req.getGraduateTeacher());
        entity.setUndergraduateTeacher(req.getUndergraduateTeacher());
        entity.setSchoolID(req.getSchoolID());
        Date datenow = new Date();
        entity.setApplyTime(datenow);
        teacherDataMapper.addCompanyTeacher(entity);
    }

    @Override
    public void updateCompanyTeacher(UpdateCompanyTeacherReq req) {
        val entity = teacherDataMapper.selectCompanyTeacherById(req.getId());
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        entity.setCompanyTeacher(req.getCompanyTeacher());
        entity.setGraduateTeacher(req.getGraduateTeacher());
        entity.setUndergraduateTeacher(req.getUndergraduateTeacher());
        teacherDataMapper.updateCompanyTeacher(entity);
    }

    @Override
    public void deleteCompanyTeacher(int id) {
        val entity = teacherDataMapper.selectCompanyTeacherById(id);
        if (entity==null){
            throw new ResponseException("不合法的id");
        }
        teacherDataMapper.deleteCompanyTeacher(id);
    }

    @Override
    public List<CompanyTeacherEntity> selectCompanyTeacher() {
        return teacherDataMapper.selectCompanyTeacher();
    }
}
