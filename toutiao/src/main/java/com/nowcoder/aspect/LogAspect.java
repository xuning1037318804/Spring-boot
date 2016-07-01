package com.nowcoder.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by xuning on 2016/6/27.
 */
@Aspect
//进行初始化，没有它就显示不出来；
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.nowcoder.controller.*Controller.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        StringBuilder sb = new StringBuilder();
        for(Object arg: joinPoint.getArgs()){
            sb.append("args:"+arg.toString()+"|");
        }
        logger.info("BeforeMethod "+ sb.toString());
        logger.info("start time"+new Date());
        String classAndMethod = joinPoint.getTarget().getClass().getName()
                +"类的"+joinPoint.getSignature().getName();
        logger.info("后置通知："+classAndMethod+"方法执行结束");
    }

    @After("execution(* com.nowcoder.controller.*Controller.*(..))")
    public void afterMethod(JoinPoint joinPoint){
            logger.info("AfterMethod");
            logger.info("end time"+new Date());
            String classAndMethod = joinPoint.getTarget().getClass().getName()
                    +"类的"+joinPoint.getSignature().getName();
            logger.info("后置通知："+classAndMethod+"方法执行结束");
    }
}
