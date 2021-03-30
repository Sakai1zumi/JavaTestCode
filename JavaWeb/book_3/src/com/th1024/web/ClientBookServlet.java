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

/**
 * @author TuHong
 * @create 2021-03-30 21:37
 */
public class ClientBookServlet extends BaseServlet{

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
        page.setUrl("client/bookServlet?action=page");

        //3. 保存Page对象至Request域中
        req.setAttribute("page",page);
        //4. 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    /**
     * 按照给定的价格区间进行分页操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的参数pageNO和pageSize
        int pageNo = WebUtils.getValue(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.getValue(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.getValue(req.getParameter("min"), 0);
        int max = WebUtils.getValue(req.getParameter("max"), Integer.MAX_VALUE);
        //2. 调用BookService.page(pageNo,pageSize)获取Page对象
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
        //解决价格筛选后的分页条跳转bug
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        //如果有最小价格的参数，追加到分页条的地址参数中
        if(req.getParameter("min") != null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        //如果有最大价格的参数，追加到分页条的地址参数中
        if(req.getParameter("max") != null){
            sb.append("&max=").append(req.getParameter("max"));
        }
        //设置请求地址
        page.setUrl(sb.toString());

        //3. 保存Page对象至Request域中
        req.setAttribute("page",page);
        //4. 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
