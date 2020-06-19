package com.inter.impl;

import com.inter.Calculator;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qby
 * @date 2020/6/19 20:15
 */
@ContextConfiguration(value = {"classpath:/conf/ioc3.xml"})
@RunWith(SpringRunner.class)
public class MyCalculatorNoInterfaceTest extends TestCase {
    @Test
    public void test01() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:/conf/ioc3.xml");


        Calculator bean2 = (Calculator) applicationContext.getBean("myCalculator");

        System.out.println(bean2);
        System.out.println(bean2.getClass());
    }
}