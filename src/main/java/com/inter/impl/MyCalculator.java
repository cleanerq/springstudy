package com.inter.impl;

import com.inter.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

/**
 * @author qby
 * @date 2020/6/19 17:57
 */
@Component
public class MyCalculator implements Calculator {
    Logger logger = LoggerFactory.getLogger(Calculator.class);

    public Integer add(int i, int j) {
        logger.info("目标方法执行");
        return i + j;
    }

    public Integer sub(int i, int j) {
        return i - j;
    }

    public Integer mul(int i, int j) {
        return i * j;
    }

    public Integer div(int i, int j) {
        return i / j;
    }
}
