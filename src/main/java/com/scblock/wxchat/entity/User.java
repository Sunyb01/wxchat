package com.scblock.wxchat.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: sunyubin
 * @Date: 2020/4/17 18:18
 * @Description: 用户实体类
 */
@Data
public class User implements UserDetails , Serializable{
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 权限
     */
    private int rule;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 最后登录时间
     */
    private String lastLoginTime;
    /**
     * 激活状态
     */
    private int activation;
    /**
     * 权限
     */
    private List<Rule> rules;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>(rules.size());
        for (Rule rs : rules) {
            authorities.add(new SimpleGrantedAuthority(rs.getRuleName()));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
