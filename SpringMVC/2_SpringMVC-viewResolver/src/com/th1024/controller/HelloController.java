package com.th1024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TuHong
 * @create 2021-04-25 16:02
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){

//        return "success";
        //相对路径
        return "../../hello";
    }

    /*
    forward:转发到一个页面
    forward:/hello.jsp--转发到当前项目下的hello.jsp页面
    一定需要加上/，不加/就是相对路径
    forward:前缀的转发不会由配置的视图解析器进行拼串
     */
    @RequestMapping("/handle01")
    public String handle01(){
        System.out.println("handle01");
        return "forward:/hello.jsp";
    }
    @RequestMapping("/handle02")
    public String handle02(){
        System.out.println("handle02");
        return "forward:/handle01";
    }

    /*
    重定向到hello.jsp页面
    redirect:/hello.jsp--重定向至当前项目下的hello.jsp页面，SpringMVC会为路径自动拼接项目名
    原生Servlet重定向路径需要加上项目名才能成功
    redirect:前缀的重定向操作不会由配置的视图解析器进行拼串
     */
    @RequestMapping("/handle03")
    public String handle03(){
        System.out.println("handle03");
        return "redirect:hello.jsp";
    }
    @RequestMapping("/handle04")
    public String handle04(){
        System.out.println("handle04");
        return "redirect:/handle03";
    }
}
