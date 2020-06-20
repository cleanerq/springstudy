package com.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author qby
 * @date 2020/6/20 16:47
 */
@ContextConfiguration(value = "classpath:/conf/ApplicationContext.xml")
@RunWith(SpringRunner.class)
public class JdbcTemplateTest {
    @Autowired
    private DataSource dataSourceA;

    @Test
    public void test01() throws SQLException {
        Connection connection = dataSourceA.getConnection();
        System.out.println(connection);
    }
}
