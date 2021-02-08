package com.th1024.demo1;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author TuHong
 * @create 2021-02-08 0:18
 */
public class OtherTest {

    /*
    获取构造器结构
     */
    public void test1(){
        Class<Person> personClass = Person.class;
        //getConstructors()：获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = personClass.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println();
        //getDeclaredConstructors()：获取当前运行时类中声明的所有的构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }
    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;

        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);

    }

    /*
    获取运行时类的带泛型的父类
     */
    @Test
    public void test3(){
        Class<Person> personClass = Person.class;

        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);

    }

    /*
    获取运行时类的带泛型的父类的泛型

    代码：逻辑性代码 vs 功能性代码
     */
    @Test
    public void test4(){
        Class<Person> personClass = Person.class;

        Type genericSuperclass = personClass.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
//        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());

    }

    /*
    获取运行时类实现的接口
     */
    @Test
    public void test5(){
        Class<Person> personClass = Person.class;

        Class<?>[] interfaces = personClass.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }

        System.out.println();
        //获取运行时类的父类实现的接口
        Class<?>[] interfaces1 = personClass.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }
    }

    /*
    获取运行时类所在的包
     */
    @Test
    public void test6(){
        Class<Person> personClass = Person.class;

        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);
    }

    /*
    获取运行时类声明的注解
    */
    @Test
    public void test7() {
        Class<Person> personClass = Person.class;

        Annotation[] annotations = personClass.getAnnotations();
        for(Annotation a : annotations){
            System.out.println(a);
        }
    }
}
