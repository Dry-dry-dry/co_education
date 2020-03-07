package com.service.impl;

import com.entity.ApplyProjectEntity;
import com.entity.PlanProjetEntity;
import com.entity.dto.AddApplyProjectReq;
import com.entity.dto.AddPlanProjetReq;
import com.entity.dto.UpdateApplyProjectReq;
import com.entity.dto.UpdatePlanProjetReq;
import com.mapper.ConstructionProjectMapper;
import com.service.ConstructionProjectService;
import com.util.ResponseException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ConstructionProjectServiceImpl implements ConstructionProjectService {

    @Autowired
    private ConstructionProjectMapper constructionProjectMapper;

    @Override
    public List<ApplyProjectEntity> selectApplyProject() {
        return constructionProjectMapper.selectApplyProject();
    }

    @Override
    public void deleteApplyProject(int id) {
        val entity = constructionProjectMapper.selectApplyProjectById(id);
        if (entity == null) {
            throw new ResponseException("不合法的id");
        }
        constructionProjectMapper.deleteApplyProject(id);
    }

    @Override
    public void addApplyProject(AddApplyProjectReq req) {
        val entity = new ApplyProjectEntity();
        entity.setCentreProject(req.getCentreProject());
        entity.setCityProject(req.getCityProject());
        entity.setLocalProject(req.getLocalProject());
        entity.setOtherProject(req.getOtherProject());
        entity.setProvincialProject(req.getProvincialProject());
        constructionProjectMapper.addApplyProject(entity);
    }

    @Override
    public void updateApplyProject(UpdateApplyProjectReq req) {
        val entity = constructionProjectMapper.selectApplyProjectById(req.getId());
        if (entity == null) {
            throw new ResponseException("不合法的id");
        }
        entity.setCentreProject(req.getCentreProject());
        entity.setCityProject(req.getCityProject());
        entity.setLocalProject(req.getLocalProject());
        entity.setOtherProject(req.getOtherProject());
        entity.setProvincialProject(req.getProvincialProject());
        constructionProjectMapper.updateApplyProject(entity);
    }

    @Override
    public List<PlanProjetEntity> selectPlanProject() {
        return constructionProjectMapper.selectPlanProject();
    }

    @Override
    public void deletePlanProject(int id) {
        val entity = constructionProjectMapper.selectPlanProjectById(id);
        if (entity == null) {
            throw new ResponseException("不合法的id");
        }
        constructionProjectMapper.deletePlanProject(id);

    }

    @Override
    public void addPlanProject(AddPlanProjetReq req) {
        val entity = new PlanProjetEntity();
        entity.setCentreProject(req.getCentreProject());
        entity.setCityProject(req.getCityProject());
        entity.setLocalProject(req.getLocalProject());
        entity.setOtherProject(req.getOtherProject());
        entity.setProvincialProject(req.getProvincialProject());
        constructionProjectMapper.addPlanProject(entity);
    }

    @Override
    public void updatePlanProject(UpdatePlanProjetReq req) {
        val entity = constructionProjectMapper.selectPlanProjectById(req.getId());
        if (entity == null) {
            throw new ResponseException("不合法的id");
        }
        entity.setCentreProject(req.getCentreProject());
        entity.setCityProject(req.getCityProject());
        entity.setLocalProject(req.getLocalProject());
        entity.setOtherProject(req.getOtherProject());
        entity.setProvincialProject(req.getProvincialProject());
        constructionProjectMapper.updatePlanProject(entity);
    }
}
