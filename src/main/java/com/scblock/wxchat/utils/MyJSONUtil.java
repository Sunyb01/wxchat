package com.scblock.wxchat.utils;

import com.google.gson.Gson;

import java.util.Map;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 19:24
 * @Description: JSON转换器
 */
public class MyJSONUtil {

    /**
     * @Description: 将json字符串装换为对象
     * @author: sunyubin
     * @Date 2020/4/17 19:31
     * @Param [strJson]
     * @Return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String, Object> getMap(String strJson) {
        Map<String,Object> map = MyJSONUtil.getGson().fromJson(strJson, Map.class);
        return map;
    }
    /**
     * @Description: 单例解析对象
     * @author: sunyubin
     * @Date 2020/4/17 19:31
     * @Param []
     * @Return com.google.gson.Gson
     */
    public static Gson getGson() {
        return GsonHelper.gson;
    }
    /**
     * @Author: sunyubin
     * @Date: 2020/4/17 19:30
     * @Description: 内部帮助类
     */
    private static class GsonHelper{
        private static Gson gson = new Gson();
    }
}
