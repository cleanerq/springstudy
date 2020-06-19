package com.aop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author qby
 * @date 2020/6/19 18:33
 */
@Aspect
@Component
public class LogUtilsCglib {
    private  static Logger logger = LoggerFactory.getLogger(LogUtilsCglib.class);

    /**
     * 1、本类引用
     * 2、其他的切面引用
     */
    @Pointcut("execution(public int com.inter.impl.MyCalculatorNoInterface.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public static void logStart() {
        logger.info("【logStart】方法开始执行，用的参数列表【{}】");
    }

    @AfterReturning("pointCut()")
    public static void logReturn() {
        logger.info("【logReturn】方法开始执行，用的参数列表【{}】");
    }

    @AfterThrowing("pointCut()")
    public static void logExcpetion() {
        logger.info("【logExcpetion】方法开始执行，用的参数列表【{}】");
    }

    @After("pointCut()")
    public static void logEnd() {
        logger.info("【logEnd】方法开始执行，用的参数列表【{}】");
    }
}
