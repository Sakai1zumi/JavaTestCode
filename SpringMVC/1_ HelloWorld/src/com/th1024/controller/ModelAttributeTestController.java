package com.th1024.controller;

import com.th1024.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author TuHong
 * @create 2021-06-08 15:13
 */
@Controller
public class ModelAttributeTestController {

    /*
    测试ModelAttribute注解
    使用场景：书城图书修改
    页面端：显示所有要修改的图书信息，包含所有字段
    servlet：调用dao，String sql = "update t_book set `name` = ?,
                                   `author` = ?,`price` = ?,
                                   `sales` = ?,`stock` = ?,
                                   `img_path` = ? where `id` = ?";

    实际场景？
    并非全字段修改，只会修改部分字段，如price，stock，sales等
    1. 不修改的字段可以直接展示，不提供输入框进行修改
    2. Controller中的处理方法参数直接写Book对象，SpringMVC会自动封装（没有带的值为null）
    3. 若此时调用全字段更新，可能会将某些字段更新为null

    如何保证全字段更新的时候，只更新页面携带的数据？
    1. 修改dao，不现实
    2. 不直接创建对象，而是更新从数据库中获取的对象的某些字段值
        1) 从数据库中获取对应id的对象
        2) 将页面携带的数据更新到获取的对象中，页面中没携带的数据则为原来的值
        3) 调用全字段更新保存到数据库

    @ModelAttribute
    标注在参数上：取出保存的数据
    标注在方法上：提前于目标方法运行
     */

    private Object o1;
    private Object o2;
    private Object b1;
    private Object b2;

    @RequestMapping("/updateBook")
    public String updateBook(Map<String,Object> map,
            @ModelAttribute("book") Book book){
        System.out.println("页面提交的信息" + book);
        Object book1 = map.get("book");

        b2 = book;
        o2 = map;
        System.out.println("o1 == o2?" + (o1 == o2));
        System.out.println("b1 == b2?" + (b1 == b2) + "; b2 == book1?" + (b2 == book1) );//均为true，说明使用的均为同一个对象
        return "success";
    }

    @ModelAttribute
    public void myModelAttribute(Map<String, Object> map){
        Book book = new Book(100,"西游记","吴承恩",98.98,11,200,null);
        System.out.println("数据库中获取的信息" + book);
        map.put("book",book);
        b1 = book;
        o1 = map;
        System.out.println("ModelAttribute保存数据，类型为" + map.getClass());//org.springframework.validation.support.BindingAwareModelMap
    }

}
