package com.scblock.wxchat.interceptor;

import java.lang.annotation.*;

/**
 * @Author: sunyubin
 * @Date: 2019/12/26 12:56
 * @Description: 防刷注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AccessLimt {

    int seconds();
    int maxCount();
    boolean needLogin() default true;
}
