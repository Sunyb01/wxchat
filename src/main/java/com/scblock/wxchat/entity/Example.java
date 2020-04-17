package com.scblock.wxchat.entity;

import lombok.Data;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:25
 * @Description: 考试结果
 */
@Data
public class Example {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 问题题干
     */
    private String problem;
    /**
     * 答案
     */
    private String answer;
    /*
     * 创建时间
     */
    private String createTime;
    /**
     * 使用标识
     */
    private int flag;
}
