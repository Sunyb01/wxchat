package com.scblock.wxchat.service.impl;

import com.google.common.collect.Maps;
import com.scblock.wxchat.service.OtherAPIService;
import com.scblock.wxchat.utils.HttpUtil;
import com.scblock.wxchat.utils.MyJSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 20:01
 * @Description: 第三发Api调用服务实现类
 */
@Service
public class OtherAPIServiceImpl implements OtherAPIService {

    private static Logger log = LoggerFactory.getLogger(OtherAPIServiceImpl.class);

    @Autowired
    private HttpUtil httpUtil;

    @Override
    public Map<String, Object> getWeatherInfo(String longitude, String latitude) {
        String jsonStr = null;
        Map<String, Object> resultMap = null;
        try {
            jsonStr = httpUtil.getResult(longitude, latitude);
            resultMap = MyJSONUtil.getMap(jsonStr);
        } catch (Exception e) {
            log.error("第三方调用异常,异常为:{}", e.getMessage());
        }
        if(CollectionUtils.isEmpty(resultMap)) {
            resultMap = Maps.newHashMap();
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> getIpInfo(String ip) {
        String jsonStr = null;
        Map<String, Object> resultMap = null;
        try {
            jsonStr = httpUtil.getIpResult(ip);
            resultMap = MyJSONUtil.getMap(jsonStr);
        } catch (Exception e) {
            log.error("第三方调用异常,异常为:{}", e.getMessage());
        }
        return resultMap;
    }
}
