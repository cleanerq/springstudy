package com.bean;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qby
 * @date 2020/6/17 16:59
 */
public class IOCTest2 {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("/conf/ioc2.xml");

    /**
     * 默认都是null
     */
    @Test
    public void test01() {
        Person bean = applicationContext.getBean("person03", Person.class);
        logger.info(bean.toString());

        Car bean1 = applicationContext.getBean(Car.class);

        logger.info(String.valueOf(bean1 == bean.getCar()));

    }

    /**
     * 默认都是null
     */
    @Test
    public void test09() {
        AirPlane bean = applicationContext.getBean("airPlane01", AirPlane.class);
        logger.info(bean.toString());
        logger.info("容器创建完成");


    }


}
