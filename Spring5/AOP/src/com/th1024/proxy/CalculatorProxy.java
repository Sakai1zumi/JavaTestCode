package com.th1024.proxy;

import com.th1024.bean.Calculator;
import com.th1024.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 为Calculator.java生成代理对象的类
 *
 * @author TuHong
 * @create 2021-04-16 14:08
 */
public class CalculatorProxy {

//    public static Calculator getProxy(Calculator calculator){
//
//        ClassLoader classLoader = calculator.getClass().getClassLoader();
//        Class<?>[] interfaces = calculator.getClass().getInterfaces();
//        InvocationHandler handler = new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                /*
//                Object proxy：代理对象，提供给JDK使用
//                Method method：当前将要执行的目标对象的方法
//                Object[] args：目标对象的方法执行所需要的参数
//                 */
//                Object result = null;
//                try {
//                    LogUtils.logStart(method,args);
//                    result = method.invoke(calculator, args);
//                    LogUtils.logReturn(method,result);
//                } catch (Exception e) {
//                    LogUtils.logException(method,e);
//                } finally {
//                    LogUtils.logEnd(method);
//                }
//                return result;
//            }
//
//        };
//
//        //如果目标对象没有实现任何接口，即interfaces为空，则无法创建代理对象
//        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, handler);
//        return (Calculator) proxy;
//
//    }
}
