package com.dao;

import com.bean.Book;
import org.springframework.stereotype.Repository;

/**
 * @author qby
 * @date 2020/6/19 16:32
 */
@Repository
public class BookDao extends BaseDao<Book> {

    @Override
    public void save() {
        System.out.println("保存图书");
    }
}
