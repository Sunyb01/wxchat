package com.scblock.wxchat.common;

public enum ResultEnum {
    SUCCESS(2000, "成功"), ERROR(5000, "内部错误,请联系管理员"),
    DATA_BASE_ERROR(4000, "数据异常"), PARAMETER_ERROR(6000, "参数有误"),
    USER_REPET(7000, "用户已存在,请勿重复注册!"),USER_IS_NOT(7001, "用户不存在!"),
    USER_NOT_VALIDATAION(7003, "用户未认证!"),
    USER_DROP_OUT(7002, "注销成功!"),
    USER_INSUFFICIENT_PERMISSIONS(70004, "权限不足");
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
