package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面的执行顺序测试
 * 
 * @author qby
 * @date 2020/6/20 10:55
 */
public class ValidateAspectXml {
    private static Logger logger = LoggerFactory.getLogger(ValidateAspectXml.class);


    public static void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        logger.info("logStart【{}】方法开始执行，用的参数列表【{}】", name, Arrays.asList(args));
    }

    public static void logReturn(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        logger.info("logReturn【{}】方法开始执行，用的参数列表【{}】, 返回结果:{}", name, Arrays.asList(args), result);
    }

    public static void logExcpetion(JoinPoint joinPoint, RuntimeException runtimeException) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        logger.info("logExcpetion【{}】方法开始执行，用的参数列表【{}】，异常信息【{}】", name, Arrays.asList(args), runtimeException.toString());
    }

    public static void logEnd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        logger.info("logEnd【{}】方法开始执行，用的参数列表【{}】", name, Arrays.asList(args));
    }
}
