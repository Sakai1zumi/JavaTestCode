package com.th1024.test;

import com.th1024.bean.Emp;
import com.th1024.bean.Stu;
import com.th1024.bean.User;
import com.th1024.config.SpringConfig;
import com.th1024.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author TuHong
 * @create 2021-04-07 21:30
 */
public class BeanTest {

    @Test
    public void test1(){
        //1. 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2. 获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.test();
    }

    @Test
    public void test2(){
        //1. 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        //2. 获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.test();
    }

    @Test
    public void test3(){
        //1. 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        //2. 获取配置创建的对象
        UserService service = context.getBean("userService", UserService.class);
        System.out.println(service);
        service.test();
    }

    @Test
    public void test4(){
        //1. 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        //2. 获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

    @Test
    public void test5(){
        //1. 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        //2. 获取配置创建的对象
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu);
    }

    @Test
    public void test6(){
        //1. 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
        //2. 获取配置创建的对象(基于注解方式实现对象创建)
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        //基于注解方式注入属性
        userService.test();
    }

    @Test
    public void test7(){
        //1. 加载Spring配置文件
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //2. 获取配置创建的对象(基于注解方式实现对象创建)
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.test();
    }


}
