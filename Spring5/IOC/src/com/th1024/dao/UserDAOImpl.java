package com.th1024.dao;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author TuHong
 * @create 2021-04-07 21:53
 */

@Repository(value = "UserDAOImpl")
public class UserDAOImpl implements UserDAO{
    @Override
    public void test() {
        System.out.println("dao-test");
    }
}
