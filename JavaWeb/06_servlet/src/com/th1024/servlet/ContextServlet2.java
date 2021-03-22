package com.th1024.servlet; /**
 * @author TuHong
 * @create 2021-03-22 11:33
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        System.out.println("Context2获取域数据key1：" + context.getAttribute("key1"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
