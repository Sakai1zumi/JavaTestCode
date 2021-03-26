package com.th1024.service;

import com.th1024.pojo.User;

/**
 * @author TuHong
 * @create 2021-03-23 21:23
 */
public interface UserService {

    void registerUser(User user);

    User login(User user);

    boolean existsUsername(String username);
}
