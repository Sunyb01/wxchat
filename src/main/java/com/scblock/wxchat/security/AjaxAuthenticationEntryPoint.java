package com.scblock.wxchat.security;

import com.scblock.wxchat.common.ResultMsg;
import com.scblock.wxchat.utils.MyJSONUtil;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: sunyubin
 * @Date: 2020/4/20 11:22
 * @Description: 未登錄時處理
 */
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse resp,
                         AuthenticationException authException) throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        ResultMsg respBean = ResultMsg.error();
        if (authException instanceof InsufficientAuthenticationException) {
            respBean.setMsg("请求失败，请联系管理员!");
        }
        out.write(MyJSONUtil.getGson().toJson(respBean));
        out.flush();
        out.close();

    }
}
