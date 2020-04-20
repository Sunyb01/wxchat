package com.scblock.wxchat.security;

import com.scblock.wxchat.common.ResultEnum;
import com.scblock.wxchat.common.ResultMsg;
import com.scblock.wxchat.utils.MyJSONUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: sunyubin
 * @Date: 2020/4/20 11:31
 * @Description: 登出處理
 */
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(MyJSONUtil.getGson().toJson(ResultMsg.dropOut(ResultEnum.USER_DROP_OUT)));
        out.flush();
        out.close();
    }
}
