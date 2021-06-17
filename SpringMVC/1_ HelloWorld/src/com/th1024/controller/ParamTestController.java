package com.th1024.controller;

import com.th1024.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author TuHong
 * @create 2021-04-22 21:35
 */

@RequestMapping("/param")
@Controller
public class ParamTestController {

    /*
    SpringMVC如何获取请求带来的各种信息，默认获取请求参数的方式：直接给方法形参列表写一个和请求参数同名的变量，此变量就用来接收请求参数的值
    @RequestParam：获取请求参数，默认请求必须携带该参数
    @RequestParam("user") String user == String user = request.getParameter("user");

    @RequestParam("user")
	@PathVariable("user")
            /book/【{user}pathvariable】?【user=admin(requestparam)】
                value:指定要获取的参数的key required:这个参数是否必须的
                defaultValue:默认值。没带默认是null；

    @RequestHeader：获取请求头中某个key的值
    @RequestHeader("User-Agent") String userAgent == String userAgent = request.getParameter("User-Agent");

    @CookieValue：获取某个Cookie的值
     */

    @RequestMapping(value = "/handle01")
    public String handle01(@RequestParam(value = "user",required = false,defaultValue = "defaultUser") String user,
                           @RequestHeader(value = "User-Agent",required = false,defaultValue = "defaultUserAgent") String userAgent,
                           @CookieValue(value = "JSESSIONID",required = false) String cookieValue){
        System.out.println("变量：" + user);
        System.out.println("请求头信息" + userAgent);
        System.out.println("cookie的值" + cookieValue);
        return "success";
    }

    /*
    请求的参数如果是一个POJO，SpringMVC会自动为这个POJO赋值
    1. 将POJO中的每一个属性，从request参数中尝试获取并封装
    2. 可以进行级联封装
    3. 请求参数的参数名和对象中的属性名一一对应
     */
    @RequestMapping("/book")
    public String addBook(Book book){
        System.out.println("获取的图书信息：" + book);
        return "success";
    }

    /*
    SpringMVC可以在参数上写原生API

    HttpServletRequest
    HttpServletResponse
    HttpSession
     */

    @RequestMapping("/handle02")
    public String handle02(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        request.setAttribute("reqParam","reqAttr");
        session.setAttribute("sessionParam","sessionAttr");
        return "success";
    }
}
