package com.scblock.wxchat.service.impl;

import com.scblock.wxchat.service.OtherAPIService;
import com.scblock.wxchat.utils.HttpUtil;
import com.scblock.wxchat.utils.MyJSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 20:01
 * @Description: 第三发Api调用服务实现类
 */
@Service
public class OtherAPIServiceImpl implements OtherAPIService {

    @Autowired
    private HttpUtil httpUtil;

    @Override
    public Map<String, Object> getWeatherInfo(String longitude, String latitude) {
        String jsonStr = httpUtil.getResult(longitude, latitude);
        Map<String, Object> resultMap = MyJSONUtil.getMap(jsonStr);
        return resultMap;
    }
}
