package com.inter.impl;

import com.inter.Calculator;
import org.springframework.stereotype.Component;

/**
 * @author qby
 * @date 2020/6/19 17:57
 */
@Component
public class MyCalculator implements Calculator {
    public int add(int i, int j) {
        return i + j;
    }

    public int sub(int i, int j) {
        return i - j;
    }

    public int mul(int i, int j) {
        return i * j;
    }

    public int div(int i, int j) {
        return i / j;
    }
}
