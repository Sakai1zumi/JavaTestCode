package com.th1024.demo;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author TuHong
 * @create 2021-02-07 13:56
 */
public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;

        /*
        newInstance()：调用此方法，创建对应的运行时类的对象，默认调用空参构造器

        要求：
        1. 运行时类必须提供空参的构造器
        2. 空参的构造器访问权限不能过小，通常设置为public

        在javabean中要求提供一个public的空参构造器，原因：
        1. 便于通过反射，创建运行时类的对象
        2. 便于子类继承此运行时类时，默认调用super()时，保证父类此构造器存在
         */
        Person p = personClass.newInstance();
        System.out.println(p);
    }

    //体会反射的动态性
    @Test
    public void test2(){

        String classPath = "";
        for(int i = 0;i < 100;i ++){
            int num = new Random().nextInt(3);//0、1、2
            switch(num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.th1024.demo.Person";
                    break;
            }

            try {
                Object instance = getInstance(classPath);
                System.out.println(instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    /*
    创建一个指定类的对象
    classPath：指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception{
        Class<?> aClass = Class.forName(classPath);
        return aClass.newInstance();
    }
}
