package com.th1024.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 如何将此类（切面类）中的这些方法（通知方法）动态地在目标方法运行的各个位置切入
 *
 * @author TuHong
 * @create 2021-04-16 14:20
 */

@Aspect
@Component
public class LogUtils {

    /*
    五个通知注解
    @Before：前置通知，在目标方法调用之前运行
    @After：后置通知，在目标方法结束之后运行
    @AfterReturning：返回通知，在目标方法正常返回之后运行
    @AfterThrowing：异常通知，在目标方法抛出异常之后通知
    @Around：环绕通知，在目标方法前后执行

    try{
        @Before
        method.invoke(obj,args);
        @AfterReturning
    }catch(e){
        @AfterThrowing
    }finally{
        @After
    }

     */

    /*
    切入点表达式
    固定写法：execution(访问权限符 返回值类型 方法全类名(参数列表))
    其中访问权限符可省略不写，默认为public
    通配符：
        *：
            1. 匹配一个或多个字符：execution(public int com.th1024.bean.impl.MyMath*r.*(..))
            2. 匹配任意一个参数：execution(public int com.th1024.bean.impl.MyMath*r.*(int,*))，第二个参数可为任意类型
            3. 匹配一层路径
            4. 匹配所有返回值类型
        ..：
            1. 匹配任意多个参数，任意类型参数
            2. 匹配任意多层路径：execution(public int com.th1024..MyMath*r.*(int,*))

    最精确的：execution(public int com.th1024.bean.impl.MyMathCalculator.add(int,int))
    最模糊的：execution( * *.*(..))
     */


    @Before(value = "execution(public int com.th1024.bean.impl.MyMathCalculator.*(..))")
    public static void logStart(JoinPoint joinPoint){
        //获取到目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取到目标方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("【"+signature.getName()+"】方法开始执行，参数列表为"+ Arrays.asList(args));
    }

    //returning="result"，设置result接收方法返回值
    @AfterReturning(value = "execution(public int com.th1024.bean.impl.MyMathCalculator.*(..))",returning = "result")
    public static void logReturn(JoinPoint joinPoint,Object result){
        System.out.println("【"+joinPoint.getSignature().getName()+"】方法执行完成，返回结果为"+ result);
    }

    //throwing="e"，设置e接收方法抛出的异常
    @AfterThrowing(value = "execution(public int com.th1024.bean.impl.MyMathCalculator.*(..))",throwing = "e")
    public static void logException(JoinPoint joinPoint,Exception e){
        System.out.println("【"+joinPoint.getSignature().getName()+"】方法出现异常，异常信息为"+ e);
    }

    @After(value = "execution(public int com.th1024.bean.impl.MyMathCalculator.*(..))")
    public static void logEnd(JoinPoint joinPoint){
        System.out.println("【"+joinPoint.getSignature().getName()+"】方法最终执行完成");
    }

}
