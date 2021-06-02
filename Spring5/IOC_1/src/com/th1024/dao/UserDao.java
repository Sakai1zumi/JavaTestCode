package com.th1024.dao;

import com.th1024.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @author TuHong
 * @create 2021-05-31 9:46
 */
@Repository
public class UserDao extends BaseDao<User>{
    @Override
    public void save() {
        System.out.println("UserDao保存用户");
    }
}
