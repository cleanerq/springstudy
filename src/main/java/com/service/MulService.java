package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qby
 * @date 2020/6/21 20:38
 */
@Service
public class MulService {
    @Autowired
    private BookService bookService;

    @Transactional
    public void mulTx() {
        // 都是可以设置的
        // REQUIRES_NEW
        bookService.checkout("jack", "1");
        // 传播行为来设置这个事务方法和之前的大事务共享一个事务（使用同一条连接）
        // REQUIRED 抛出异常
        bookService.updatePrice("1", 998d);
    }
}
