package com.dao;

import com.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @author qby
 * @date 2020/6/19 16:32
 */
@Repository
public class UserDao extends BaseDao<User> {

    @Override
    public void save() {
        System.out.println("保存用户");
    }
}
