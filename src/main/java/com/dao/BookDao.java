package com.dao;

import com.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Repository;

/**
 * @author qby
 * @date 2020/6/19 16:32
 */
@Repository
public class BookDao extends BaseDao<Book> {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplateB;

    @Autowired
    private JdbcTemplate jdbcTemplateB;

    @Override
    public void save() {
        System.out.println("保存图书");
    }


    /**
     * 减余额
     * 减去某个用户的余额
     */
    public void updateBalance(String username, Double price) {
        String sql = "UPDATE account set balance = balance - ? where username = ?";

        jdbcTemplateB.update(sql, price, username);
    }

    /**
     * 获取某本图书的价格
     *
     * @return
     */
    public Double getPrice(String isbn) {
        String sql = "SELECT t.price from book t where t.isbn = ?";

        Double aDouble = jdbcTemplateB.queryForObject(sql, Double.class, isbn);
        return aDouble;
    }

    /**
     * 减库存，减去某本书的库存，为了简单期间
     */
    public void updateStock(String isbn) {
        String sql = "update book_stock t set t.stock = t.stock - 1 where t.isbn = ?";
        jdbcTemplateB.update(sql, isbn);

    }

    public void updatePrice(String isbn, Double price) {
        String sql = "UPDATE book set price = ? where isbn = ?";
        jdbcTemplateB.update(sql, price, isbn);
    }
}
