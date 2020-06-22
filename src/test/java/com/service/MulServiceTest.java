package com.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qby
 * @date 2020/6/21 20:47
 */
@ContextConfiguration(value = "classpath:/conf/ApplicationContext.xml")
@RunWith(SpringRunner.class)
public class MulServiceTest extends TestCase {
    @Autowired
    private BookService bookService;

    @Autowired
    private MulService mulService;

    @Test
    public void test01() {
//        mulService.mulTx();

        // 效果都没改 虽然里面两个方法都是 require_new
        bookService.mulTx();
    }
}