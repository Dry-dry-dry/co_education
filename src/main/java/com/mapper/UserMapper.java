package com.mapper;

import com.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户接口
 */
@Repository
public interface UserMapper {

    //用户注册
    void addUser(UserEntity entity);
    void deleteUser(String id);
    void updateUser(UserEntity entity);

    //查找区县学校和市直属学校
    List<UserEntity> seletUserByRole(String role);

    UserEntity selectUserByID(int id);
    UserEntity selectUserByUsername(String username);
    List<UserEntity> selectAllUser();

    //用于用户登录判断
    UserEntity selectUserByNamePassword(String username, String password);
}
