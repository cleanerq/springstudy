package com.inter.impl;

import com.inter.Calculator;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qby
 * @date 2020/6/19 17:58
 */
@ContextConfiguration(value = {"classpath:/conf/ioc3.xml"})
@RunWith(SpringRunner.class)
public class MyCalculatorTest extends TestCase {


    @Test
    public void test01() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:/conf/ioc3.xml");
        Calculator bean = applicationContext.getBean(Calculator.class);
        bean.add(1,1);

        System.out.println("=========================");

        bean.div(1,0);
//        System.out.println(bean);
//        System.out.println(bean.getClass());

    }

}