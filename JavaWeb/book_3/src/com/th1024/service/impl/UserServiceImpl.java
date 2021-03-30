package com.th1024.service.impl;

import com.th1024.dao.UserDAO;
import com.th1024.dao.impl.UserDAOImpl;
import com.th1024.pojo.User;
import com.th1024.service.UserService;

/**
 * @author TuHong
 * @create 2021-03-23 21:29
 */
public class UserServiceImpl implements UserService {
    private UserDAO dao = new UserDAOImpl();

    @Override
    public void registerUser(User user) {
        dao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return dao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(dao.queryUserByUsername(username) == null){
            return false;
        }else{
            return true;
        }
    }
}
