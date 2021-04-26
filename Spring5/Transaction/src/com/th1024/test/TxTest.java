package com.th1024.test;

import com.th1024.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TuHong
 * @create 2021-04-19 16:11
 */
public class TxTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");

    @Test
    public void test1(){
        BookService bookService = ioc.getBean(BookService.class);

        bookService.checkout("Tom","ISBN-001");


    }
}
