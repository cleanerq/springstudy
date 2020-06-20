package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author qby
 * @date 2020/6/19 18:33
 */
@Aspect
@Component
public class LogUtils {
    private static Logger logger = LoggerFactory.getLogger(LogUtils.class);

    /**
     * 1、本类引用
     * 2、其他的切面引用
     */
    @Pointcut("execution(public Integer com.inter.impl.MyCalculator.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public static void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        logger.info(" logStart【{}】方法开始执行，用的参数列表【{}】", name, Arrays.asList(args));
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public static void logReturn(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        logger.info(" logReturn【{}】方法开始执行，用的参数列表【{}】, 返回结果:{}", name, Arrays.asList(args), result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "runtimeException")
    public static void logExcpetion(JoinPoint joinPoint, RuntimeException runtimeException) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        logger.info(" logExcpetion【{}】方法开始执行，用的参数列表【{}】，异常信息【{}】", name, Arrays.asList(args), runtimeException.toString());
    }

    @After("pointCut()")
    public static void logEnd(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        logger.info(" logEnd【{}】方法开始执行，用的参数列表【{}】", name, Arrays.asList(args));
    }

    /**
     * 环绕通知
     */
//    @Around("pointCut()")
    public Object myAround(ProceedingJoinPoint pjp)  {
        // 就是 method.invoke

        Object proceed = null;
        try {
            logger.info(" 环绕前置 方法开始");
            proceed = pjp.proceed(pjp.getArgs());
            logger.info(" 环绕返回值 {}", proceed);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.info(" 环绕异常 {}", throwable.toString());
        } finally {
            logger.info(" 环绕后置 方法结束");
        }


        return proceed;
    }
}
