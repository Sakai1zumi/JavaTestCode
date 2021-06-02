package com.th1024.test;

import com.th1024.bean.User;
import com.th1024.service.BookService;
import com.th1024.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TuHong
 * @create 2021-05-31 9:52
 */
public class IOCTest {

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = applicationContext.getBean(BookService.class);
        UserService userService = applicationContext.getBean(UserService.class);

        bookService.save();
        userService.save();

    }
}
