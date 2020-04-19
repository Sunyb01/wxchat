package com.scblock.wxchat.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @Author: sunyubin
 * @Date: 2020/4/19 10:54
 * @Description: 自定义用户权限认证
 */
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String authUserNane = authentication.getName();
        String authPassword = (String) authentication.getPrincipal();

        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
