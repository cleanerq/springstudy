package com.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.io.FileNotFoundException;

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
    public void test01() throws FileNotFoundException {
//        bookService.checkout("jack", "1");

//        Double price = bookService.getPrice("1");
//        System.out.println("读取到的数据：" + price);

        System.out.println(bookService.getClass());
    }


}