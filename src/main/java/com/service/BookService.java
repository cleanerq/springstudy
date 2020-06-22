package com.service;

import com.bean.Book;
import com.dao.BookDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author qby
 * @date 2020/6/19 16:31
 */
@Service
public class BookService extends BaseService<Book> {
    Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookDao bookDao;


    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public Double getPrice(String isbn) {
        return bookDao.getPrice(isbn);
    }

    /**
     *
     * 事物细节
     * isolation
     * 用户买书操作
     * @param username
     * @param isbn
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void checkout(String username, String isbn) {
        // 减库存
        bookDao.updateStock(isbn);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 得到价格
        Double price = bookDao.getPrice(isbn);
        // 减余额
        bookDao.updateBalance(username, price);

        logger.info("结账完成！！！");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updatePrice(String isbn, Double price) {
        bookDao.updatePrice(isbn, price);

    }

    /**
     * 本类事务方法之间的调用就只是一个事务，不管本类的事务方法是否加上 REQUIRES_NEW
     *
     */
    @Transactional
    public void mulTx() {
        checkout("jack", "1");
        updatePrice("1", 998d);
        int i = 10/0;
    }
}
