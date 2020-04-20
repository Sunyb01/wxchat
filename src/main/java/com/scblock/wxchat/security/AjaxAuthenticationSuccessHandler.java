package com.scblock.wxchat.security;

import com.scblock.wxchat.common.ResultMsg;
import com.scblock.wxchat.utils.MyJSONUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: sunyubin
 * @Date: 2020/4/20 11:27
 * @Description: 登錄成功處理
 */
public class AjaxAuthenticationSuccessHandler  implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
        Object principal = authentication.getPrincipal();
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(MyJSONUtil.getGson().toJson(ResultMsg.success()));
        out.flush();
        out.close();
    }
}
