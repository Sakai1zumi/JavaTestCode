package com.th1024.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 多个增强类
 * @author TuHong
 * @create 2021-04-09 15:08
 */

@Component
@Aspect
@Order(1)
public class UserProxy1 {

    //相同切入点抽取
    @Pointcut(value = "execution(* com.th1024.bean.User.test(..))")
    public void pointDemo(){}

    //前置通知
    @Before(value = "pointDemo()")
    public void before(){
        System.out.println("before1 User-test");
    }
}
