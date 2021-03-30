package com.th1024.dao;

import com.th1024.pojo.Book;

import java.util.List;

/**
 * @author TuHong
 * @create 2021-03-28 10:12
 */
public interface BookDAO {

    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
