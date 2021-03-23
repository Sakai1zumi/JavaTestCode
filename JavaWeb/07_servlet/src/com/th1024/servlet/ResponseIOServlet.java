package com.th1024.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author TuHong
 * @create 2021-03-23 13:55
 */
public class ResponseIOServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");

        //往客户端回传数据
        PrintWriter writer = resp.getWriter();
        writer.write("response content");
        writer.write("中文内容");//中文存在乱码
    }
}
