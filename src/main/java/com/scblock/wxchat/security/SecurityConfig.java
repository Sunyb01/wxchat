package com.scblock.wxchat.security;

import com.alibaba.druid.pool.PreparedStatementPool;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scblock.wxchat.common.ResultEnum;
import com.scblock.wxchat.common.ResultMsg;
import com.scblock.wxchat.utils.MyJSONUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @Bean
    public AuthenticationProvider authProvider(){
        return new UserAuthenticationProvider();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/**", "/example/**", "/user/*")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginProcessingUrl("/user/login")
                .successHandler((rep, resp, authentication) -> {
                    Object principal = authentication.getPrincipal();
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(MyJSONUtil.getGson().toJson(ResultMsg.success()));
                    out.flush();
                    out.close();
                }).failureHandler((rep, resp, e) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    ResultMsg rm = ResultMsg.success();
                    if (e instanceof LockedException) {
                        rm.setMsg("账户被锁定，请联系管理员!");
                    } else if (e instanceof CredentialsExpiredException) {
                        rm.setMsg("密码过期，请联系管理员!");
                    } else if (e instanceof AccountExpiredException) {
                        rm.setMsg("账户过期，请联系管理员!");
                    } else if (e instanceof DisabledException) {
                        rm.setMsg("账户被禁用，请联系管理员!");
                    } else if (e instanceof BadCredentialsException) {
                        rm.setMsg("用户名或者密码输入错误，请重新输入!");
                    }
                    out.write(MyJSONUtil.getGson().toJson(rm));
                    out.flush();
                    out.close();
                })
                .and()
                .logout()
                .logoutUrl("/user/getOut")
                .logoutSuccessHandler((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(MyJSONUtil.getGson().toJson(ResultMsg.dropOut(ResultEnum.USER_DROP_OUT)));
                    out.flush();
                    out.close();
                }).permitAll()
                .and()
                .csrf().disable().exceptionHandling()
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest res, HttpServletResponse resp,
                                         AuthenticationException authException) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        resp.setStatus(401);
                        PrintWriter out = resp.getWriter();
                        ResultMsg respBean = ResultMsg.error("访问失败!");
                        if (authException instanceof InsufficientAuthenticationException) {
                            respBean.setMsg("请求失败，请联系管理员!");
                        }
                        out.write(MyJSONUtil.getGson().toJson(respBean));
                        out.flush();
                        out.close();
                    }
                });

    }
}
