package com.th1024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @RequestMapping的使用
 *
 * @author TuHong
 * @create 2021-04-21 16:29
 */

@RequestMapping("/haha")
@Controller
public class RequestMappingTestController {

    @RequestMapping("/handle01")
    public String handle01(){
        System.out.println("RequestMappingTestController handle01...");
        return "error";
    }

    /*
    RequestMapping的其他属性
    method：限定请求方式
        method = RequestMethod.POST：限定只接受POST请求

    params：规定请求的参数，支持简单的表达式
        param1：表示请求必须包含名为param1的请求参数
        !param1：表示请求不能包含名为param1的请求参数
        param1 ！= value1：表示请求包含名为param1的请求参数，但其值不能为value1
        {"param1=value1","param2"}：请求必须同时满足两个表达式，即包含param1和param2，且param1的值必须为value1
            params = {"username!=123","pwd","!age"})：发送请求时必须带有username，pwd参数，必须没有age参数，且username参数不能为123

    headers：规定请求头，和params一样能写简单的表达式

    consumes：
    produces
     */

    @RequestMapping(value = "/handle02",method = RequestMethod.POST)
    public String handle02(){
        System.out.println("handle02...");
        return "success";
    }

    @RequestMapping(value = "/handle03",params = {"username!=123","pwd","!age"})
    public String handle03(){
        System.out.println("handle03...");
        return "success";
    }

    /*
    设置headers，User-Agent：浏览器信息
    让Edge不能访问，Chrome能访问

    Chrome:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.85 Safari/537.36
    Edge:Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.72 Safari/537.36 Edg/90.0.818.42
     */
    @RequestMapping(value = "/handle04",headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.85 Safari/537.36"})
    public String handle04(){
        System.out.println("handle04...");
        return "success";
    }
}
