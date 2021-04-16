package com.th1024.service;

import com.th1024.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author TuHong
 * @create 2021-04-07 21:51
 */

//value属性值可以省略不写，默认是类名首字母小写
@Service(value = "userService")  //<bean id="userService" class="..."></bean>
public class UserService {

    //添加注入属性注解
    @Autowired  //根据类型进行注入
    /*
    首先按照类型去容器中寻找对应的组件
    找到一个，直接赋值
    没找到，抛异常
    找到多个（多个类存在继承关系），按照变量名作为id继续匹配
    可以使用@Qualifier(value = "UserDAOImpl1")根据指定的id寻找

    @Autowired可以标注在构造器上、方法上、参数上、属性上、注解上
    @Qualifier可以标注在方法上、参数上、属性上、注解上
    @Resource拓展性更强，此注解为Java的标准--javax.annotation.Resource
     */
//    @Qualifier(value = "UserDAOImpl1")//根据指定的名称进行注入
//    @Resource(name = "UserDAOImpl1")//既可以根据类型进行注入，也可以根据名称进行注入
    private UserDAO dao;

    @Value(value = "test")
    private String str;

    public void setDao(UserDAO dao){
        this.dao = dao;
    }

    public void test(){
        System.out.println("service-test");
        dao.test();
        System.out.println(str);
    }

    public void test1(){
        System.out.println("service-test1");
    }
}
