package com.th1024.service;

import com.th1024.pojo.Book;

import java.util.List;

/**
 * @author TuHong
 * @create 2021-03-28 10:49
 */
public interface BookService {

    void addBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();
}
