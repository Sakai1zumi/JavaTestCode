package com.th1024.test;

import com.th1024.pojo.User;
import com.th1024.service.UserService;
import com.th1024.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author TuHong
 * @create 2021-03-23 21:36
 */
public class UserServiceImplTest {
    UserService service = new UserServiceImpl();

    @Test
    public void registerUser() {
        service.registerUser(new User(null,"abc2021","123456","abc@qq.com"));
        service.registerUser(new User(null,"jkl2021","123456","jkl@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(service.login(new User(null, "abc2021", "123456", "abc@qq.com")));
    }

    @Test
    public void existsUsername() {
        if(service.existsUsername("abc20211")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }
    }
}