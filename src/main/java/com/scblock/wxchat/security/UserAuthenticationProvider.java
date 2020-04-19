package com.scblock.wxchat.security;

import com.scblock.wxchat.entity.User;
import com.scblock.wxchat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Objects;

/**
 * @Author: sunyubin
 * @Date: 2020/4/19 10:54
 * @Description: 自定义用户权限认证
 */
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserMapper um;
    @Autowired
    private BCryptPasswordEncoder bpe;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String authUserNane = authentication.getName();
        String authPassword = (String) authentication.getPrincipal();
        User user = um.selectUserByName(authPassword);
        if(Objects.isNull(user)) {
            throw new AuthenticationCredentialsNotFoundException("authentication message is null");
        }
        if (bpe.matches(authPassword, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        }
        throw new BadCredentialsException("authError");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
