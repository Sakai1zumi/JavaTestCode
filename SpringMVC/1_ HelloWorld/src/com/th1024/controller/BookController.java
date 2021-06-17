package com.th1024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author TuHong
 * @create 2021-04-22 11:15
 */

@RequestMapping("/book")
@Controller
public class BookController {

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String addBook(){
        System.out.println("添加图书");
        return "success";
    }

    @RequestMapping(value = "/{bid}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bid") Integer id){
        System.out.println("删除"+ id +"号图书");
        return "success";
    }

    @RequestMapping(value = "/{bid}",method = RequestMethod.PUT)
    public String updateBook(@PathVariable("bid") Integer id){
        System.out.println("更新"+ id +"号图书");
        return "success";
    }

    @RequestMapping(value = "/{bid}",method = RequestMethod.GET)
    public String getBook(@PathVariable("bid") Integer id){
        System.out.println("获取"+ id +"号图书");
        return "success";
    }

}
