package com.service;

import com.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qby
 * @date 2020/6/19 16:32
 */
public class BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    public void save() {
        System.out.println("自动注入的dao " + baseDao);
        baseDao.save();
    }
}
