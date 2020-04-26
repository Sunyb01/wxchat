package com.scblock.wxchat.config;

import com.scblock.wxchat.interceptor.UserAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: sunyubin
 * @Date: 2020/4/26 12:56
 * @Description: springboot配置项
 */
@Configuration
public class SpringWebMvcConfigure implements WebMvcConfigurer {

    @Autowired
    private UserAuthenticationInterceptor uai;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] paths = {"/user/logout", "/example/**"};
        registry.addInterceptor(uai).addPathPatterns(paths).excludePathPatterns("/user/login");
    }
}
