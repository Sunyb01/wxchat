package com.scblock.wxchat.controller;

import com.scblock.wxchat.common.ResultMsg;
import com.scblock.wxchat.common.ResultEnum;
import com.scblock.wxchat.service.OtherAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:40
 * @Description: 其他服务调用
 */
@RestController
public class OtherAPIController {

    @Autowired
    private OtherAPIService ops;

    @GetMapping("/getWeather")
    public ResultMsg getWeatherInfo(String longitude, String latitude) {
        Map<String, Object> objMap = ops.getWeatherInfo(longitude, latitude);
        return ResultMsg.success(ResultEnum.SUCCESS, objMap);
    }
}
