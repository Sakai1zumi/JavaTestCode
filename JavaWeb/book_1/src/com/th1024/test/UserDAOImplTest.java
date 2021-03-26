package com.th1024.test;

import com.th1024.dao.UserDAO;
import com.th1024.dao.impl.UserDAOImpl;
import com.th1024.pojo.User;
import org.junit.Test;

/**
 * @author TuHong
 * @create 2021-03-23 21:17
 */
public class UserDAOImplTest {
    UserDAO dao = new UserDAOImpl();

    @Test
    public void queryUserByUsername() {
        if(dao.queryUserByUsername("admin1") == null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(dao.queryUserByUsernameAndPassword("admin","admin666") == null){
            System.out.println("用户名或密码错误，查询失败");
        }else{
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(dao.saveUser(new User(null, "fenghualian", "666666", "fhl@gmail.com")));
    }
}