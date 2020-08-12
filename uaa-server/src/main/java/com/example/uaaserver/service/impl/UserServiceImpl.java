package com.example.uaaserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.uaaserver.dao.UserDao;
import com.example.uaaserver.model.UserEntity;
import com.example.uaaserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    /**
     * 根据用户名，查询系统用户
     */
    public UserEntity queryByUserName(String username){
        return baseMapper.queryByUserName(username);
    }

    //认证
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = baseMapper.queryByUserName(username);
        //将userDto转成json
        String principal = JSON.toJSONString(userEntity);
        UserDetails userDetails = User.withUsername(principal)
                .password(userEntity.getPassword())
                .authorities("p1").build();

        return userDetails;
    }
}
