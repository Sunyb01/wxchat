package com.scblock.wxchat.common;

import java.io.Serializable;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:29
 * @Description: 返回结果
 */
public class ResultMsg implements Serializable {

    private int code;
    private String msg;
    private Object data;

    public ResultMsg(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @Description: 成功
     * @author: sunyubin
     * @Date 2020/4/17 18:35
     * @Param [re, object]
     * @Return com.scblock.wxchat.utils.Result
     */
    public static ResultMsg success(ResultEnum re, Object object){
        return new ResultMsg(re.getCode(), re.getMsg(), object);
    }
    /**
     * @Description: 成功 参数
     * @author: sunyubin
     * @Date 2020/4/17 18:37
     * @Param [re]
     * @Return com.scblock.wxchat.utils.Result
     */
    public static ResultMsg success() {
        return  success(ResultEnum.SUCCESS, null);
    }

    public static ResultMsg success(Object obj) {
        return success(ResultEnum.SUCCESS, obj);
    }
    /**
     * @Description: 错误
     * @author: sunyubin
     * @Date 2020/4/17 18:38
     * @Param [re]
     * @Return com.scblock.wxchat.utils.Result
     */
    public static ResultMsg error(ResultEnum re){
        return error(re, null);
    }
    public static ResultMsg error(){
        ResultEnum error = ResultEnum.USER_NOT_VALIDATAION;
        return new ResultMsg(error.getCode(), error.getMsg(), "null");
    }
    public static ResultMsg error(Object obj) {
        return error(ResultEnum.ERROR, obj);
    }

    public static ResultMsg error(ResultEnum re, Object obj){
        return new ResultMsg(re.getCode(), re.getMsg(), obj);
    }


    public static ResultMsg dropOut(ResultEnum res) {
        return new ResultMsg(res.getCode(), res.getMsg(), null);
    }
}
