package com.th1024.web;

import com.th1024.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author TuHong
 * @create 2021-03-31 21:06
 */
public class CookieServlet extends BaseServlet{

    protected void testCookiePath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        //getContextPath()：得到工程路径
        cookie.setPath(req.getContextPath() + "/abc");// 工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有Path路径的Cookie");
    }

    protected void liveCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60 * 60);//设置Cookie一小时之后删除
        resp.addCookie(cookie);
        resp.getWriter().write("创建存活时间为一小时的cookie");
    }

    protected void deleteCookieNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("defaultLife", req.getCookies());
        if(cookie != null){
            cookie.setMaxAge(0);//0表示马上删除
            resp.addCookie(cookie);
            resp.getWriter().write("cookie已删除");
        }
    }

    protected void defaultLifeCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方案一：创建一个同名的cookie，并修改值
//        Cookie cookie = new Cookie("key1", "newValue1");
//        resp.addCookie(cookie);

        //方案二：查找到需要修改的Cookie对象，调用setValue()赋予新值
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if(cookie != null){
            cookie.setValue("newValue1");
            resp.addCookie(cookie);
        }

        resp.getWriter().write("修改Cookie-key1的值");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            //getName()返回Cookie的key（名）
            //getValue()返回Cookie的Value值
            resp.getWriter().write("Cookie:" + cookie.getName() + "-" + cookie.getValue() + "<br/>");
        }

        Cookie cookie = CookieUtils.findCookie("key1",cookies);

        //如果cookie不为null，说明找到了需要的cookie
        if(cookie != null){
            resp.getWriter().write("cookie已找到");
        }

    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //2. 通知客户端保存cookie
        resp.addCookie(cookie);
        //1. 创建Cookie对象
        Cookie cookie1 = new Cookie("key2", "value2");
        //2. 通知客户端保存cookie
        resp.addCookie(cookie1);

        resp.getWriter().write("Cookie创建成功");
    }
}
