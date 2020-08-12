package com.example.uaaserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.uaaserver.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends IService<UserEntity>, UserDetailsService {
    /**
     * 根据用户名，查询系统用户
     */
    UserEntity queryByUserName(String username);
}
