package com.th1024.test;

import com.th1024.pojo.Book;
import com.th1024.pojo.Page;
import com.th1024.service.BookService;
import com.th1024.service.impl.BookServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author TuHong
 * @create 2021-03-30 14:53
 */
public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void page() {
        Page<Book> page = bookService.page(1, Page.PAGE_SIZE);
        System.out.println(page);
    }

    @Test
    public void pageByPrice() {
        Page<Book> page = bookService.pageByPrice(1, Page.PAGE_SIZE,10,50);
        System.out.println(page);
    }
}