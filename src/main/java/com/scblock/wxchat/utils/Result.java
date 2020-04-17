package com.scblock.wxchat.utils;
/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:29
 * @Description: 返回结果
 */
public class Result {

    private int code;
    private String msg;
    private Object data;

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    /**
     * @Description: 成功
     * @author: sunyubin
     * @Date 2020/4/17 18:35
     * @Param [re, object]
     * @Return com.scblock.wxchat.utils.Result
     */
    public static Result success(ResultEnum re, Object object){
        return new Result(re.getCode(), re.getMsg(), object);
    }
    /**
     * @Description: 成功 参数
     * @author: sunyubin
     * @Date 2020/4/17 18:37
     * @Param [re]
     * @Return com.scblock.wxchat.utils.Result
     */
    public static Result success(ResultEnum re) {
        return  success(re, null);
    }

    /**
     * @Description: 错误
     * @author: sunyubin
     * @Date 2020/4/17 18:38
     * @Param [re]
     * @Return com.scblock.wxchat.utils.Result
     */
    public static Result error(ResultEnum re){
        return new Result(re.getCode(), re.getMsg(), null);
    }


    enum ResultEnum{
        SUCCESS(2000, "成功"), ERROR(5000, "内部错误,请联系管理员"),
        DATA_BASE_ERROR(4000, "数据异常"), PARAMETER_ERROR(6000, "参数有误");
        private int code;
        private String msg;

        ResultEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
