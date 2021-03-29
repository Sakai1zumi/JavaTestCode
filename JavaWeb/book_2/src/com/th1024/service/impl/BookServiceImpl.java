package com.th1024.service.impl;

import com.th1024.dao.BookDAO;
import com.th1024.dao.impl.BookDAOImpl;
import com.th1024.pojo.Book;
import com.th1024.service.BookService;

import java.util.List;

/**
 * @author TuHong
 * @create 2021-03-28 10:54
 */
public class BookServiceImpl implements BookService {

    private BookDAO dao = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        dao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        dao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        dao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return dao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return dao.queryBooks();
    }
}
