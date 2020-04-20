package com.scblock.wxchat.security;

import com.alibaba.druid.util.StringUtils;
import com.scblock.wxchat.entity.User;
import com.scblock.wxchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunyubin
 * @Date: 2020/4/20 11:36
 * @Description: 登录用户信息验证
 */
@Service
public class ValidationUserDetailService implements UserDetailsService {

    @Autowired
    private UserService us;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(name)) {
            name = "";
        }
        User user = us.selectUserByName(name);
        List<GrantedAuthority> rules = new ArrayList<>();
        return user;
    }
}
