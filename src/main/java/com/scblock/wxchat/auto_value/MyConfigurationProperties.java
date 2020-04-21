package com.scblock.wxchat.auto_value;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: sunyubin
 * @Date: 2020/4/21 11:13
 * @Description: 配置文件属性导入
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
@ConfigurationProperties(prefix = "my.weather")
public class MyConfigurationProperties {

    private String url;

    private String key;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
