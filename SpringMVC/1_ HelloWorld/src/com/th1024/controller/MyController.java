package com.th1024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TuHong
 * @create 2021-04-21 16:13
 */

/*
运行细节：
1. 流程
    1. 客户端点击链接，发送http://localhost:8080/1_HelloWorld/handle01请求
    2. 请求发送到Tomcat服务器，并被SpringMVC的前端控制器dispatcherServlet接收
    3. 查看请求地址是否和@RequestMapping标注的值匹配，确定处理请求调用的类及方法
    4. 前端控制器利用反射执行目标方法
    5. 方法执行完成之后会返回跳转的页面地址
    6. 利用视图解析器进行拼串得到完整的页面地址
    7. 前端控制器将请求转发到页面

@RequestMapping
    表名此方法应该处理什么类型的请求，“/handle01”表名请求的地址为当前项目下加上handle01

SpringMVC配置文件
    web应用的/WEB-INF/下创建一个名为  前端控制器名-servlet.xml
 */

@Controller //添加@Controller表名这个类是一个处理器
public class MyController {

    @RequestMapping("/handle01")
    public String handle01(){
        System.out.println("MyController handle01...");
        return "success";
    }
}
