package com.example.uaaserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.uaaserver.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    /**
     * 根据用户名，查询系统用户
     */
    UserEntity queryByUserName(String username);

}
