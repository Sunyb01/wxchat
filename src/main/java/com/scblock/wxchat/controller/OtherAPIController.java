package com.scblock.wxchat.controller;

import com.alibaba.druid.util.StringUtils;
import com.google.common.collect.Maps;
import com.scblock.wxchat.common.ResultMsg;
import com.scblock.wxchat.common.ResultEnum;
import com.scblock.wxchat.service.OtherAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:40
 * @Description: 其他服务调用
 */
@RestController
@RequestMapping("/api")
public class OtherAPIController {

    @Autowired
    private OtherAPIService ops;

    /**
     * @Description: 天气状况插叙
     * @author: sunyubin
     * @Date 2020/4/18 14:36
     * @Param [longitude, latitude]
     * @Return com.scblock.wxchat.common.ResultMsg
     */
    @GetMapping("/getWeather")
    public ResultMsg getWeatherInfo(String longitude, String latitude) {
        if(StringUtils.isEmpty(longitude)) {
            longitude = "39.9";
        }
        if(StringUtils.isEmpty(latitude)) {
            latitude = "116.3";
        }
        Map<String, Object> objMap = ops.getWeatherInfo(longitude, latitude);
        return ResultMsg.success(ResultEnum.SUCCESS, objMap);
    }
    /**
     * @Description: 获取ip地址
     * @author: sunyubin
     * @Date 2020/4/18 15:29
     * @Param [ip]
     * @Return com.scblock.wxchat.common.ResultMsg
     */
    @GetMapping("/getIp")
    public ResultMsg getIpInfo(String ip) {
        Map<String, Object> map = null;
        if(StringUtils.isEmpty(ip)) {
            map = Maps.newHashMap();
        }else{
            map = ops.getIpInfo(ip);
        }
        return ResultMsg.success(map);
    }
}
