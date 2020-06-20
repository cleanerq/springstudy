package com.inter.impl;

import com.inter.CalculatorXml;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qby
 * @date 2020/6/20 14:21
 */
public class MyCalculatorXmlTest extends TestCase {

    @Test
    public void test01() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/conf/ioc4.xml");
        CalculatorXml bean = applicationContext.getBean(CalculatorXml.class);
        bean.add(2,3);
    }
}