package com.th1024.test;

import com.th1024.dao.BookDAO;
import com.th1024.dao.impl.BookDAOImpl;
import com.th1024.pojo.Book;
import com.th1024.pojo.Page;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author TuHong
 * @create 2021-03-28 10:42
 */
public class BookDAOTest {

    BookDAO dao = new BookDAOImpl();

    @Test
    public void addBook() {
        dao.addBook(new Book(null,"时间简史","霍金",49.9,10000,200,null));
    }

    @Test
    public void deleteBookById() {
        dao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        dao.updateBook(new Book(30,"时间简史","霍金",59.9,10000,200,null));
    }

    @Test
    public void queryBookById() {
        Book book = dao.queryBookById(21);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = dao.queryBooks();
        for (Book book : books){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(dao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = dao.queryForPageItems(0, 4);
        for (Book book : books){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(dao.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void queryForPageItemsByPrice() {
        List<Book> books = dao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,10,50);
        for (Book book : books){
            System.out.println(book);
        }
    }
}