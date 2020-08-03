package com.example.usereurekaclient.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class GlobalInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object obj) throws Exception {
        System.out.println("进来了GlobalInterceptor....");
        String secretKey = request.getHeader("from");
        if(!StringUtils.isNotBlank(secretKey)||secretKey.equals("gateway")){
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write("error");
            return false;
        }
        return true;
    }

}