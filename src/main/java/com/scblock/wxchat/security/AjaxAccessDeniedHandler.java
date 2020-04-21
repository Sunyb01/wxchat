package com.scblock.wxchat.security;

import com.scblock.wxchat.common.ResultEnum;
import com.scblock.wxchat.common.ResultMsg;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: sunyubin
 * @Date: 2020/4/21 17:22
 * @Description: 没有访问权限
 */
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        PrintWriter out = httpServletResponse.getWriter();
        out.write(ResultMsg.error(ResultEnum.USER_INSUFFICIENT_PERMISSIONS).toString());
        out.flush();
        out.close();
    }
}
