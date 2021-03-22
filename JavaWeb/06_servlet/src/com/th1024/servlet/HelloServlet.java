package com.th1024.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author TuHong
 * @create 2021-03-21 11:03
 */
public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //1. 可以获取servlet程序的别名servlet-name值
        System.out.println(servletConfig.getServletName());
        //2. 获取初始化参数init-param
        System.out.println(servletConfig.getInitParameter("username"));
        System.out.println(servletConfig.getInitParameter("url"));
        //3. 获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet被访问了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
