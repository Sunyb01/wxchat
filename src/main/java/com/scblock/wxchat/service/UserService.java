package com.scblock.wxchat.service;

import com.scblock.wxchat.entity.User;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:10
 * @Description: 用户服务类
 */
public interface UserService {
    /**
     * @Description: 添加新的用户,成功返回1, 失败返回0
     * @author: sunyubin
     * @Date 2020/4/19 10:34
     * @Param [phone, password]
     * @Return int
     */
    int insert(String phone, String password);
    /**
     * @Description: 通過用戶名查詢用戶信息
     * @author: sunyubin
     * @Date 2020/4/20 10:35
     * @Param [username]
     * @Return com.scblock.wxchat.entity.User
     */
    User selectUserByName(String username);
}
