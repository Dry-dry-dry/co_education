package com.controller;

import com.entity.UserEntity;
import com.mapper.UserMapper;
import com.service.ProcessService;
import com.util.Response;
import com.util.WorkflowBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "/api/user/")
@Api(description = "用户登录接口")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public Response login(@RequestBody UserEntity userEntity) {
        UserEntity user = userMapper.selectUserByNamePassword(userEntity.getUsername(),userEntity.getPassword());
        if(user == null){
            return Response.error("false");
        }else {
            return Response.ok(user);
        }
    }

}
