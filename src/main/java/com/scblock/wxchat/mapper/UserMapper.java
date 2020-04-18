package com.scblock.wxchat.mapper;

import com.scblock.wxchat.entity.User;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:12
 * @Description: 用户mapper
 */
public interface UserMapper {
    /**
     * @Description: 用户的添加,添加成功返回受影响的行数,失败返回0
     * @author: sunyubin
     * @Date 2020/4/18 20:23
     * @Param [user]
     * @Return int
     */
    int insert(User user);
}
