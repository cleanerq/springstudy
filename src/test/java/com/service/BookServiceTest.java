package com.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

/**
 * @author qby
 * @date 2020/6/20 21:09
 */
@ContextConfiguration(value = "classpath:/conf/ApplicationContext.xml")
@RunWith(SpringRunner.class)
public class BookServiceTest extends TestCase {
    @Autowired
    private BookService bookService;

    @Test
    public void test01() {
        bookService.checkout("jack", "1");
    }

}