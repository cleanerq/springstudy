package com.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qby
 * @date 2020/6/20 23:51
 */
public class SourceTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/conf/ioc2.xml");
        Person person03 = applicationContext.getBean("person03", Person.class);
        System.out.println(person03);
    }
}
