package com.service;

import com.bean.Book;
import com.dao.BookDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * 用户买书操作
     * @param username
     * @param isbn
     */
    @Transactional
    public void checkout(String username, String isbn) {
        // 减库存
        bookDao.updateStock(isbn);
        // 得到价格
        Double price = bookDao.getPrice(isbn);
        // 减余额
        bookDao.updateBalance(username, price);
        logger.info("结账完成！！！");
    }
}
