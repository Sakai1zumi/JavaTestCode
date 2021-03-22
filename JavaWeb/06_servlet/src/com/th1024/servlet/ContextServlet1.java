package com.th1024.servlet; /**
 * @author TuHong
 * @create 2021-03-22 11:31
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext context = getServletContext();
        System.out.println("保存之前key1的值：" + context.getAttribute("key1"));
        context.setAttribute("key1","value1");
        System.out.println("保存之后域数据key1的值：" + context.getAttribute("key1"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
