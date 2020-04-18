package com.scblock.wxchat.aop;

import com.scblock.wxchat.common.ConstantInfo;
import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: sunyubin
 * @Date: 2020/4/18 14:56
 * @Description: 日志记录切面
 */
@Aspect
@Component
public class LogInfoAspect {

    private static Logger log = LoggerFactory.getLogger(ConstantInfo.LOG_INFO_FILE);

    @Pointcut("execution(* com.scblock.wxchat.service.impl.*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void beforLog(JoinPoint jp){
        String methodName = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
        Object[] agrs = jp.getArgs();
        log.info("日志记录  --> 时间: {} - 开始执行方法名: {} - 参数: {}", LocalDateTime.now(), methodName, agrs);
    }

    @After("pointcut()")
    public void afterLog(JoinPoint jp){
        String methodName = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
        log.info("日志记录  --> 时间: {} - 方法名: {} ; 执行完毕!", LocalDateTime.now(), methodName);
    }
}
