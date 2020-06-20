package com.inter.impl;

import com.inter.Calculator;
import com.inter.CalculatorXml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 基于XML配置的切面类
 *
 * @author qby
 * @date 2020/6/19 17:57
 */
public class MyCalculatorXml implements CalculatorXml {
    Logger logger = LoggerFactory.getLogger(CalculatorXml.class);

    public Integer add(int i, int j) {
        logger.info("目标方法执行MyCalculatorXml");
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
