package com.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * @author qby
 * @date 2020/6/20 16:47
 */
@ContextConfiguration(value = "classpath:/conf/ApplicationContext.xml")
@RunWith(SpringRunner.class)
public class JdbcTemplateTest {
    @Autowired
    private DataSource dataSourceA;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void test01() throws SQLException {
        Connection connection = dataSourceA.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test02() {
        String sql = "update tbl_user set salary = ? where id = ?";
        int update = jdbcTemplate.update(sql, 5300, 5);
        System.out.println(update);

    }

    @Test
    public void test03() {
        String sql = "INSERT tbl_user (username, salary, age) VALUES (?,?,?)";
        Random random = new Random();
        Random randomA = new Random();

        List<Object[]> batchArgs = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Object[] batchArg = new Object[]{UUID.randomUUID().toString().substring(0, 5), random.nextInt(10000), randomA.nextInt(100)};
            batchArgs.add(batchArg);
        }

        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);

        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test04() {
        String sql = "SELECT t.id, t.age, t.salary, t.username FROM tbl_user t WHERE t.id = ?";

        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), 1);
        System.out.println(employee);
    }

    @Test
    public void test05() {
        String sql = "SELECT t.id, t.age, t.salary, t.username FROM tbl_user t WHERE t.salary > ?";
        List<Employee> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class), 4000);
        System.out.println(query);
    }

    @Test
    public void test06() {
        String sql = "SELECT MAX(t.salary) FROM tbl_user t";
        Double aDouble = jdbcTemplate.queryForObject(sql, Double.class);
        System.out.println(aDouble);
    }

    /**
     * 使用具名参数的SQL语句插入一条
     * 语法格式 :参数明
     */
    @Test
    public void test07() {
        String sql = "INSERT tbl_user (username, salary, age) VALUES (:username,:salary,:age)";

        Map<String, Object> map = new HashMap<>();
        map.put("username", "刘叉叉");
        map.put("salary", 2222);
        map.put("age", 222);
        int update = namedParameterJdbcTemplate.update(sql, map);
        System.out.println(update);
    }

    @Test
    public void test08() {

    }
}
