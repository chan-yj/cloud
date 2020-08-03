package com.example.usereurekaclient.config;

import com.example.usereurekaclient.interceptor.GlobalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurable
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private WebApplicationContext applicationContext;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("进来WebMvcConfigurer...");
        GlobalInterceptor interceptor = new GlobalInterceptor();
        //interceptor.setAuthIgnoreConfig(applicationContext.getBean(AuthIgnoreConfig.class));
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }
}