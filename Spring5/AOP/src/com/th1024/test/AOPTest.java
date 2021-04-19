package com.th1024.test;

import com.th1024.bean.Calculator;
import com.th1024.bean.User;
import com.th1024.bean.impl.MyMathCalculator;
import com.th1024.bean.impl.MyMathCalculator_xml;
import com.th1024.config.AOPConfig;
import com.th1024.proxy.CalculatorProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author TuHong
 * @create 2021-04-09 15:03
 */
public class AOPTest {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        User user = context.getBean("user", User.class);

        user.test();
    }

    @Test
    public void test2(){
        //完全使用注解开发
        ApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);

        User user = context.getBean("user", User.class);

        user.test();
    }

    /*
    使用JDK动态代理，实现日志记录功能，并且可以和业务逻辑解耦
     */
    @Test
    public void test3(){
//        Calculator calculator = new MyMathCalculator();
//
//        //获取calculator的代理对象
//        Calculator proxy = CalculatorProxy.getProxy(calculator);
//        proxy.add(1,2);
//        System.out.println("==============");
////        proxy.div(1,0);
//        System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));//[interface com.th1024.bean.Calculator]

    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //从ioc容器中获取目标对象，一定要使用接口类型
//        Calculator bean = context.getBean(Calculator.class);

        //没有接口即使用本类型获取
        MyMathCalculator bean = (MyMathCalculator) context.getBean("myMathCalculator");
        bean.add(1,2);
        System.out.println(bean);//com.th1024.bean.impl.MyMathCalculator@53fb3dab
        System.out.println(bean.getClass());//com.th1024.bean.impl.MyMathCalculator$$EnhancerBySpringCGLIB$$97cc1b67，CGLIB创建的代理对象
    }

    /*
    通知方法执行顺序
    正常执行：@Before（前置通知）-->@After（后置通知）-->@AfterReturning（正常返回）
    异常执行：@Before（前置通知）-->@After（后置通知）-->@AfterThrowing（抛出异常）
     */
    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        MyMathCalculator bean = (MyMathCalculator) context.getBean("myMathCalculator");
        bean.add(1,2);
        System.out.println("=============");
//        bean.div(2,1);
//        bean.div(1,0);
    }

    /*
    基于配置的方式实现AOP
     */
    @Test
    public void test6(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        MyMathCalculator_xml bean = (MyMathCalculator_xml) context.getBean("myMathCalculator_xml");
        bean.add(1,2);
        System.out.println("=============");
//        bean.div(2,1);
//        bean.div(1,0);
    }
}
