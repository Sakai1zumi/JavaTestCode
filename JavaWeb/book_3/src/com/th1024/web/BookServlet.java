package com.th1024.web;

import com.th1024.pojo.Book;
import com.th1024.pojo.Page;
import com.th1024.service.BookService;
import com.th1024.service.impl.BookServiceImpl;
import com.th1024.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author TuHong
 * @create 2021-03-28 11:03
 */
public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 进行分页操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的参数pageNO和pageSize
        int pageNo = WebUtils.getValue(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.getValue(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2. 调用BookService.page(pageNo,pageSize)获取Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        //设置请求地址
        page.setUrl("manager/bookServlet?action=page");

        //3. 保存Page对象至Request域中
        req.setAttribute("page",page);
        //4. 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.getValue(req.getParameter("pageNo"),0);
        pageNo += 1;
        //1. 获取请求的参数，封装成Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2. 调用BookService.addBook()保存图书
        bookService.addBook(book);
        //3. 跳转至图书列表界面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.getValue(req.getParameter("pageNo"),1);
        //1. 获取请求的参数，即图书id
        int id = WebUtils.getValue(req.getParameter("id"), 0);
        //2. 调用BookService.deleteBookById()删除图书
        bookService.deleteBookById(id);
        //3. 重定向至图书列表界面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.getValue(req.getParameter("pageNo"),1);
        //1. 获取请求的参数，封装成为Book对象
        Map<String, String[]> map = req.getParameterMap();
        Book book = WebUtils.copyParamToBean(map, new Book());
        //2. 调用BookService.updateBook(Book book)修改图书
        bookService.updateBook(book);
        //3. 重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的参数，即图书id
        int id = WebUtils.getValue(req.getParameter("id"), 0);
        //2. 调用BookService.deleteBookById()查询图书
        Book book = bookService.queryBookById(id);
        //3. 保存图书到Request域中
        req.setAttribute("book",book);
        //4. 请求转发到pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2. 将全部图书信息保存到Request域中
        req.setAttribute("books",books);
        //3. 请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
