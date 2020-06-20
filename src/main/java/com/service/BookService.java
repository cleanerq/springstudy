package com.service;

import com.bean.Book;
import com.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qby
 * @date 2020/6/19 16:31
 */
@Service
public class BookService extends BaseService<Book> {
    @Autowired
    private BookDao bookDao;

    /**
     * 用户买书操作
     * @param username
     * @param isbn
     */
    public void checkout(String username, String isbn) {
        // 减库存
        bookDao.updateStock(isbn);
        // 得到价格
        Double price = bookDao.getPrice(isbn);
        // 减余额
        bookDao.updateBalance(username, price);
    }
}
