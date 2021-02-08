package com.th1024.demo;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author TuHong
 * @create 2021-02-07 10:21
 */
public class ReflectionTest {

    /*
   关于java.lang.Class类的理解

   1. 类的加载过程：
   程序经过javac.exe命令之后，会生成一个或多个字节码文件（.class结尾），接着使用
   java.exe命令对某个字节码文件进行解释运行，相当于将某个字节码文件加载到内存中，
   此过程就称为类的加载，加载到内存中的类就称为运行时类，此运行时类就作为Class的一个实例，
   换句话说，Class的实例就对应着一个运行时类

   2. 加载到内存中的运行时类，会缓存一定的时间，在此时间之内，可以通过不同的方式获取该运行时类
   */
    //获取Class的实例的方式（前三种方式需要掌握）
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性--.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        
        //方式二：通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class<? extends Person> aClass = p1.getClass();
        System.out.println(aClass);

        //方式三：调用Class的静态方法--forName(String classPath)
        Class<?> aClass1 = Class.forName("com.th1024.demo.Person");
        System.out.println(aClass1);

        System.out.println(personClass == aClass);
        System.out.println(personClass == aClass1);

        //方式四：使用类的加载器--ClassLoader（了解）
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("com.th1024.demo.Person");
        System.out.println(aClass2);
        System.out.println(personClass == aClass2);
    }

    //反射之后，对于Person的操作
    @Test
    public void test2() throws Exception{
        Class<Person> personClass = Person.class;
        //1. 通过反射，创建Person类的对象
        Constructor<Person> cons = personClass.getConstructor(String.class, int.class);
        Person tom = cons.newInstance("Tom", 12);
        System.out.println(tom.toString());
        //2. 通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = personClass.getDeclaredField("age");
        age.set(tom,10);
        System.out.println(tom.toString());

        //调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(tom);

        System.out.println("*************************");

        //通过反射，可调用Person类的私有结构，比如私有的构造器、属性、方法
        //调用私有的构造器
        Constructor<Person> cons1 = personClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person jerry = cons1.newInstance("Jerry");
        System.out.println(jerry);

        //调用私有的属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(jerry,"JERRY");
        System.out.println(jerry);

        //调用私有的方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(jerry,"中国");//相当于jerry.showNation("中国")
        System.out.println(nation);

        /*疑问1：开发中是通过new的方式还是通过反射的方式调用公共结构
        建议：通过new的方式
        什么时候使用反射？  反射的特性：动态性

        疑问2：反射机制与封装性是否矛盾？
        不矛盾。封装性表示建议外部不要调用，实质通过反射仍旧可以调用
         */



    }

    //反射之前，对于Person的操作
    @Test
    public void test1(){
        //1. 创建Person类的对象
        Person p1 = new Person("Tom",12);

        //2. 通过对象，调用其内部属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可通过Person类的对象直接调用其内部私有结构
    }
}
