package com.example.uaaserver.controller;

import com.example.uaaserver.model.UserEntity;
import com.example.uaaserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/queryByUserName")
    public UserEntity queryByUserName(){
        return userService.queryByUserName("zhangsan");
    }

}
