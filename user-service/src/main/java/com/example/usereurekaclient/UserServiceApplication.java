package com.example.usereurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {
    //测试
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
