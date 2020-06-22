package com.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qby
 * @date 2020/6/23 1:15
 */
@ContextConfiguration(value = "classpath:/conf/ApplicationContext.xml")
@RunWith(SpringRunner.class)
public class MulServiceXmlTest extends TestCase {
    @Autowired
    private BookServiceXml bookServiceXml;

    @Autowired
    private MulServiceXml mulServiceXml;

    @Test
    public void test1() {
        mulServiceXml.mulTx();
    }

}