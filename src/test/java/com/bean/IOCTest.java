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
public class IOCTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("conf/ioc.xml");

    /**
     * 按照ID查找
     */
    @Test
    public void test01() {
        Person bean = applicationContext.getBean("person04", Person.class);
        logger.info(bean.toString());

    }

    /**
     * 使用类型找时候 如果有多个类型 IOC容器会报错 此时只能按照ID查找
     * org.springframework.beans.factory.NoUniqueBeanDefinitionException
     */
    @Test
    public void test02() {
        Person bean = applicationContext.getBean(Person.class);
        logger.info(bean.toString());
    }

    /**
     * 名称空间
     * 1、导入名称空间 xmlns:p="http://www.springframework.org/schema/p"
     * 2、写带前缀的属性key
     */
    @Test
    public void test06() {
        Person bean = applicationContext.getBean("person06", Person.class);
        logger.info(bean.toString());

    }
}
