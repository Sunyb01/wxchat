package com.scblock.wxchat.common;

public enum ResultEnum {
    SUCCESS(2000, "成功"), ERROR(5000, "内部错误,请联系管理员"),
    DATA_BASE_ERROR(4000, "数据异常"), PARAMETER_ERROR(6000, "参数有误"),
    USER_REPET(7000, "用户已存在,请勿重复注册!");
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
