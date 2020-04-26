package com.scblock.wxchat.interceptor;

import com.scblock.wxchat.common.ResultEnum;
import com.scblock.wxchat.common.ResultMsg;
import com.scblock.wxchat.entity.User;
import com.scblock.wxchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author: sunyubin
 * @Date: 2020/4/26 12:59
 * @Description: 用户验证拦截器
 */
@Component
public class UserAuthenticationInterceptor implements HandlerInterceptor {


    @Autowired
    private UserService us;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = request.getParameter("username");
        String users = (String) redisTemplate.opsForValue().get("user:" + username);
        if (Objects.isNull(users)){
            User user = us.selectUserByName(username);
            if (Objects.isNull(user)) {
                try(PrintWriter out = response.getWriter()){
                    out.write(ResultMsg.error(ResultEnum.USER_IS_NOT).toString());
                    return false;
                }
            }else{
                redisTemplate.opsForValue().set("user:" + user.getUserName(), user.getUserName(), 7200L, TimeUnit.SECONDS);
            }
        }
        return true;
    }
}
