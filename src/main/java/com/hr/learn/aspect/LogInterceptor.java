package com.hr.learn.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author nick
 * @date 19-5-17 星期五 20:31
 **/
@Aspect
@Component
public class LogInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class.getSimpleName());

    @Pointcut(value = "execution(public * com.hr.learn.service..*(..))")
    public void pointcutUserService() {
    }

    @Before(value = "pointcutUserService()")
    public void before() {
        logger.info("进入方法时间: {}", Instant.now().toString());
    }

    @After(value = "pointcutUserService()")
    public void after() {
        logger.info("退出方法时间: {}", Instant.now().toString());
    }
}
