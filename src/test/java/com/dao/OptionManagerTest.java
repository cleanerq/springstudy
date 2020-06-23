package com.dao;

import com.service.BookService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;

/**
 * @author qby
 * @date 2020/6/23 11:24
 */
@ContextConfiguration(value = "classpath:/conf/ApplicationContext.xml")
@RunWith(SpringRunner.class)
public class OptionManagerTest extends TestCase {
    @Autowired
    private OptionManager optionManager;

    @Test
    public void test01() throws FileNotFoundException {
        System.out.println(optionManager.getClass());
    }
}