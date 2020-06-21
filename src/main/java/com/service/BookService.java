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

//        int i = 1/0;
//        FileInputStream fileInputStream = new FileInputStream("d://dddddh.txt");

        logger.info("结账完成！！！");
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public Double getPrice(String isbn) {
        return bookDao.getPrice(isbn);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updatePrice(String isbn, Double price) {
        bookDao.updatePrice(isbn, price);
        int i = 10 / 0;
    }
}
