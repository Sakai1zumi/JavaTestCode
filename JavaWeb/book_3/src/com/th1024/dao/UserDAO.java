package com.th1024.dao;

import com.th1024.pojo.User;

/**
 * @author TuHong
 * @create 2021-03-23 21:01
 */
public interface UserDAO {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 返回null则表示没有查询的用户，反之亦然
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 返回null则表示没有查询的用户，反之亦然
     */
    User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1表示操作失败，返回其他结果表示受影响的行数
     */
    int saveUser(User user);
}
