package com.scblock.wxchat.exception;
/**
 * @Author: sunyubin
 * @Date: 2020/4/18 20:43
 * @Description: 自定义插入异常
 */
public class InsertDataException extends RuntimeException {
    public InsertDataException() {
        super("数据库数据添加异常!");
    }
}
