package com.scblock.wxchat.config;

import com.scblock.wxchat.utils.HttpUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 20:16
 * @Description: 配置类
 */
@Configuration
public class HttpUtilConfig {

    @Bean
    public HttpUtil httpUtil() {
        return new HttpUtil();
    }
}
