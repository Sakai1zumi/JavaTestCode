package com.th1024.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author TuHong
 * @create 2021-04-18 15:12
 */

@Aspect
@Component
@Order(2)
public class ValidateAspect {



    @Before(value = "com.th1024.utils.LogUtils.pointDemo()")
    public void vaStart(JoinPoint joinPoint){
        //获取到目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取到目标方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("validate:【"+signature.getName()+"】方法开始执行，参数列表为"+ Arrays.asList(args));
    }

    //returning="result"，设置result接收方法返回值
    @AfterReturning(value = "com.th1024.utils.LogUtils.pointDemo()",returning = "result")
    public void vaReturn(JoinPoint joinPoint, Object result){
        System.out.println("validate:【"+joinPoint.getSignature().getName()+"】方法执行完成，返回结果为"+ result);
    }

    //throwing="e"，设置e接收方法抛出的异常
    @AfterThrowing(value = "com.th1024.utils.LogUtils.pointDemo()",throwing = "e")
    public void vaException(JoinPoint joinPoint,Exception e){
        System.out.println("validate:【"+joinPoint.getSignature().getName()+"】方法出现异常，异常信息为"+ e);
    }

    @After(value = "com.th1024.utils.LogUtils.pointDemo()")
    public void vaEnd(JoinPoint joinPoint){
        System.out.println("validate:【"+joinPoint.getSignature().getName()+"】方法最终执行完成");
    }

}
