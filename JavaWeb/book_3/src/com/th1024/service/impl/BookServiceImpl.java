package com.th1024.service.impl;

import com.th1024.dao.BookDAO;
import com.th1024.dao.impl.BookDAOImpl;
import com.th1024.pojo.Book;
import com.th1024.pojo.Page;
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

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        //设置每页显示数量
        page.setPageSize(pageSize);
        //获取总记录数
        Integer pageTotalCount = dao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //设置当前页码
        page.setPageNo(pageNo);
        //获取当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //获取当前页数据
        List<Book> items = dao.queryForPageItems(begin,pageSize);
        //设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        //设置每页显示数量
        page.setPageSize(pageSize);
        //获取总记录数
        Integer pageTotalCount = dao.queryForPageTotalCountByPrice(min,max);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //设置当前页码
        page.setPageNo(pageNo);
        //获取当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //获取当前页数据
        List<Book> items = dao.queryForPageItemsByPrice(begin,pageSize,min,max);
        //设置当前页数据
        page.setItems(items);

        return page;
    }
}
