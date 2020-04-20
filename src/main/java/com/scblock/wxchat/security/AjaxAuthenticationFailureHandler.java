package com.scblock.wxchat.security;

import com.scblock.wxchat.common.ResultMsg;
import com.scblock.wxchat.utils.MyJSONUtil;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: sunyubin
 * @Date: 2020/4/20 11:25
 * @Description: 登錄失敗處理
 */
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        ResultMsg rm = ResultMsg.success();
        if (e instanceof LockedException) {
            rm.setMsg("账户被锁定，请联系管理员!");
        } else if (e instanceof CredentialsExpiredException) {
            rm.setMsg("密码过期，请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
            rm.setMsg("账户未激活，请先激活账户!");
        } else if (e instanceof DisabledException) {
            rm.setMsg("账户被禁用，请联系管理员!");
        } else if (e instanceof BadCredentialsException) {
            rm.setMsg("用户名或者密码输入错误，请重新输入!");
        } else if (e instanceof UsernameNotFoundException) {
            rm.setMsg("用戶有誤,請檢查用戶是否存在!");
        }
        out.write(MyJSONUtil.getGson().toJson(rm));
        out.flush();
        out.close();
    }
}
