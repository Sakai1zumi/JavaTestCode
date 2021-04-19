package com.th1024.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 增强类
 * @author TuHong
 * @create 2021-04-09 14:46
 */

@Component
@Aspect //生成代理对象
@Order(2) //存在多个增强类时，设置优先级，数字越小优先级越高
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* com.th1024.bean.User.test(..))")
    public void pointDemo(){}

    //前置通知
    @Before(value = "pointDemo()")
    public void before(){
        System.out.println("before User-test");
    }

    //后置通知
    @AfterReturning(value = "execution(* com.th1024.bean.User.test(..))")
    public void afterReturning(){
        System.out.println("afterReturning User-test");
    }

    //最终通知
    @After(value = "execution(* com.th1024.bean.User.test(..))")
    public void after(){
        System.out.println("after User-test");
    }

    //异常通知
    @AfterThrowing(value = "execution(* com.th1024.bean.User.test(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing User-test");
    }

    //环绕通知
    @Around(value = "execution(* com.th1024.bean.User.test(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("front User-test");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("back User-test");
    }

}
