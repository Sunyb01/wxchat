package com.scblock.wxchat.security;

import com.scblock.wxchat.common.ResultEnum;
import com.scblock.wxchat.common.ResultMsg;
import com.scblock.wxchat.utils.MyJSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import java.io.PrintWriter;

/**
 * @Author: sunyubin
 * @Date: 2020/4/19 10:29
 * @Description: 安全配置项
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(userAuthenticationProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/user/login", "/user/logout").permitAll()
                .antMatchers("/example/**").permitAll()
                .anyRequest().authenticated()
                .and()
//                .formLogin()
//                .successHandler(ajaxAuthenticationSuccessHandler())
//                .failureHandler(ajaxAuthenticationFailureHandler())
//                .and()
                .logout()
                // 设置退出的url
//                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout", "GET"))
                .logoutSuccessHandler(ajaxLogoutSuccessHandler()).permitAll()
                .and()
                .csrf().disable().exceptionHandling()
                .authenticationEntryPoint(ajaxAuthenticationEntryPoint());
    }


    @Bean
    public LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setAuthenticationSuccessHandler(ajaxAuthenticationSuccessHandler());
        loginFilter.setAuthenticationFailureHandler(ajaxAuthenticationFailureHandler());
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        loginFilter.setFilterProcessesUrl("/doLogin");
        return loginFilter;
    }


    @Bean
    public AuthenticationProvider userAuthenticationProvider() {
        return new UserAuthenticationProvider();
    }
    @Bean
    public LogoutSuccessHandler ajaxLogoutSuccessHandler() {
        return new AjaxLogoutSuccessHandler();
    }
    @Bean
    public AuthenticationSuccessHandler ajaxAuthenticationSuccessHandler() {
        return new AjaxAuthenticationSuccessHandler();
    }
    @Bean
    public AuthenticationFailureHandler ajaxAuthenticationFailureHandler(){
        return new AjaxAuthenticationFailureHandler();
    }
    @Bean
    public AuthenticationEntryPoint ajaxAuthenticationEntryPoint() {
        return new AjaxAuthenticationEntryPoint();
    }
}
