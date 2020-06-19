package com.bean;

import com.service.BookService;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.jar.JarEntry;

/**
 * 泛型依赖注入
 *
 * @author qby
 * @date 2020/6/19 16:44
 */
@ContextConfiguration(value = {"classpath:/conf/ioc3.xml"})
@RunWith(SpringRunner.class)
public class IOCTest3 {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @Test
    public void test01() {
        bookService.save();
        userService.save();

        // 带泛型的父类
        System.out.println(bookService.getClass().getGenericSuperclass());
        System.out.println(userService.getClass().getGenericSuperclass());
    }

}
