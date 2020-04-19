package com.scblock.wxchat.service.impl;

import com.scblock.wxchat.exception.InsertDataException;
import com.scblock.wxchat.mapper.UserMapper;
import com.scblock.wxchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:11
 * @Description: 用户服务实现类
 */
@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper ump;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int insert(String phone, String password) {
        int flag = ump.insert(phone, password);
        if (0 == flag ) {
            throw new InsertDataException();
        }
        return 0;
    }
}
