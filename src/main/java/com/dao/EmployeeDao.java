package com.dao;

import com.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author qby
 * @date 2020/6/20 19:46
 */
@Repository
public class EmployeeDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void saveEmployee(Employee employee) {
        String sql = "INSERT tbl_user (username, salary, age) VALUES (:username,:salary,:age)";
        BeanPropertySqlParameterSource beanPropertySqlParameterSource =
                new BeanPropertySqlParameterSource(employee);
        int update = namedParameterJdbcTemplate.update(sql, beanPropertySqlParameterSource);
    }

}
