package com.th1024.servlet; /**
 * @author TuHong
 * @create 2021-03-22 11:19
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext context = getServletConfig().getServletContext();
        //1. 获取web.xml配置的上下文参数context-param
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        System.out.println(username + ":" + password);
        //2. 获取当前的工程路径，格式：/工程路径
        System.out.println(context.getContextPath());
        //3. 获取工程部署后在服务器硬盘上的绝对路径
        /*
        /   斜杠被服务器解析为：http://ip:port/工程名/   映射到idea代码的web目录
         */
        System.out.println(context.getRealPath("/"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
