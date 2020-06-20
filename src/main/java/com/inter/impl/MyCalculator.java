package com.inter.impl;

import com.inter.Calculator;
import org.springframework.stereotype.Component;

/**
 * @author qby
 * @date 2020/6/19 17:57
 */
@Component
public class MyCalculator implements Calculator {
    public Integer add(int i, int j) {
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
