package com.scblock.wxchat.security;

import com.scblock.wxchat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: sunyubin
 * @Date: 2020/4/19 10:54
 * @Description: 自定义用户权限认证
 */
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private ValidationUserDetailService vuds;
    @Autowired
    private BCryptPasswordEncoder bpe;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String authUserName = authentication.getName();
        String authPassword = (String) authentication.getPrincipal();
        User user = (User) vuds.loadUserByUsername(authUserName);
        if(Objects.isNull(user)) {
            throw new AuthenticationCredentialsNotFoundException("用户不存在,请先注册!");
        }
        if (bpe.matches(authPassword, user.getPassword())) {
            int activationFlag = user.getActivation();
            if (0 == activationFlag) {
                throw new AccountExpiredException("账户未激活,请先激活账户!");
            }else if( 1 == activationFlag) {
                return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            }
            else if (2 == activationFlag) {
                throw new DisabledException("账户已被冻结,请联系管理员解冻!");
            }
        }
        throw new BadCredentialsException("用户名或者密码输入错误，请重新输入!");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
