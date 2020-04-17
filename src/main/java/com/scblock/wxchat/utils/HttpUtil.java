package com.scblock.wxchat.utils;

import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 19:35
 * @Description: http工具包
 */
public class HttpUtil {

    @Value("${my.weather.url}")
    public String weatherUrl;
    @Value("${my.weather.key}")
    public String weatherKey;

    public String getResult(String...arg) {
        String latitudeAndLongitude = "";
        if(arg.length == 2) {
            latitudeAndLongitude= "39.9,116.3";
        }else{
            latitudeAndLongitude= arg[0] + "," + arg[1];
        }
        Map<String, Object> parameter = Maps.newHashMap();
        parameter.put("key", weatherKey);
        parameter.put("location", latitudeAndLongitude);
        String strJson = cn.hutool.http.HttpUtil.get(weatherUrl, parameter);
        return strJson;
    }
}
