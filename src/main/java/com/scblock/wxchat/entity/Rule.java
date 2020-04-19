package com.scblock.wxchat.entity;

import lombok.Data;

/**
 * @Author: sunyubin
 * @Date: 2020/4/19 10:47
 * @Description: 权限实体
 */
@Data
public class Rule {
    /**
     * 主键
     */
    private int id;
    /**
     * 权限名
     */
    private String ruleName;
    /**
     * 标识
     */
    private int flag;
    /**
     * 用户id
     */
    private int userId;
}
