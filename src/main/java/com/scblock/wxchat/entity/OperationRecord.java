package com.scblock.wxchat.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: sunyubin
 * @Date: 2020/4/18 20:08
 * @Description: 考试记录表
 */
@Data
public class OperationRecord implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 答案
     */
    private String answer;
    /**
     * 分数
     */
    private String sorce;
    /**
     * 考试时间
     */
    private String examplateTime;
    /**
     * 用户id
     */
    private int userId;
}
