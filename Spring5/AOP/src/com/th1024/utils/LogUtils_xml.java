package com.th1024.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 如何将此类（切面类）中的这些方法（通知方法）动态地在目标方法运行的各个位置切入
 *
 * @author TuHong
 * @create 2021-04-16 14:20
 */

public class LogUtils_xml {


    public static void logStart(JoinPoint joinPoint){
        //获取到目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取到目标方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("logUtils:【"+signature.getName()+"】方法开始执行，参数列表为"+ Arrays.asList(args));
    }

    public static void logReturn(JoinPoint joinPoint,Object result){
        System.out.println("logUtils:【"+joinPoint.getSignature().getName()+"】方法执行完成，返回结果为"+ result);
    }

    public static void logException(JoinPoint joinPoint,Exception e){
        System.out.println("logUtils:【"+joinPoint.getSignature().getName()+"】方法出现异常，异常信息为"+ e);
    }

    public static void logEnd(JoinPoint joinPoint){
        System.out.println("logUtils:【"+joinPoint.getSignature().getName()+"】方法最终执行完成");
    }


    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        String name = proceedingJoinPoint.getSignature().getName();
        Object proceed = null;

        try {
            //@Before()
            System.out.println("环绕前置：【"+name+"】方法开始执行，参数列表为"+ Arrays.asList(args));
            //利用反射调用目标方法--method.invoke(obj,args)
            proceed = proceedingJoinPoint.proceed(args);
            //@AfterReturning
            System.out.println("环绕返回：【"+name+"】方法执行完成，返回结果为" + proceed);
        } catch (Exception e) {
            //@AfterThrowing
            System.out.println("环绕异常：【"+name+"】方法出现异常，异常信息为" + e);
            //为避免其他通知方法接收不到异常信息，将异常抛出
            throw new RuntimeException(e);
        } finally {
            //@After
            System.out.println("环绕后置：【"+name+"】方法最终执行完成");
        }

        return proceed;
    }

}
