package com.scblock.wxchat.service;

import java.util.Map;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 20:00
 * @Description: 第三方API服务
 */
public interface OtherAPIService {
    /**
     * @Description: 获取第三方天气服务
     * @author: sunyubin
     * @Date 2020/4/17 20:17
     * @Param [longitude, latitude]
     * @Return java.lang.String
     */
    Map<String, Object> getWeatherInfo(String longitude, String latitude);
}
