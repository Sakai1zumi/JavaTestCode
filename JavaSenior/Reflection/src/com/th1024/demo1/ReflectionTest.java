package com.th1024.demo1;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 *
 * @author TuHong
 * @create 2021-02-08 21:16
 */
public class ReflectionTest {

    /*
    通常不采用此种方式
     */
    @Test
    public void test1() throws Exception {
        Class<Person> personClass = Person.class;
        
        //创建运行时类的对象
        Person p = personClass.newInstance();

        //获取指定的属性：要求运行时类中属性声明为public
        //通常不采用此方式
        Field id = personClass.getField("id");

        /*
        设置当前属性的值
        set()：参数1--指明设置哪个对象的属性；参数2--将此属性值设置为多少
         */
        id.set(p,1001);

        /*
        获取当前属性的值
        get()：参数1--获取那个对象的当前属性值
         */
        int pId =(int) id.get(p);
        System.out.println(pId);

    }

    /*
    如何操作运行时类中的指定的属性 -- 需要掌握
     */
    @Test
    public void test2() throws Exception {
        Class<Person> personClass = Person.class;

        //创建运行时类的对象
        Person p = personClass.newInstance();
        //getDeclaredField(String name)：获取运行时类中指定变量名的属性
        Field name = personClass.getDeclaredField("name");

        //保证当前属性是可访问的
        name.setAccessible(true);

        //获取或设置属性的值
        name.set(p,"Tom");

        System.out.println(name.get(p));
    }

    /*
    如何操作运行时类中的指定的方法 -- 需要掌握
     */
    @Test
    public void test3() throws Exception {
        Class<Person> personClass = Person.class;

        //创建运行时类的对象
        Person p = personClass.newInstance();

        /*
        获取指定的某个方法
        getDeclaredMethod()：参数1--指明获取的方法的名称；参数2：指明获取的方法的形参列表
         */
        Method show = personClass.getDeclaredMethod("show", String.class);

        //保证当前方法是可访问的
        show.setAccessible(true);

        /*
        invoke()：参数1--方法的调用者；参数2--给方法形参赋值的实参
        invoke()的返回值即为对应类中调用的方法的返回值
         */
        Object returnValue = show.invoke(p,"CHN");
        System.out.println(returnValue);

        System.out.println("*************************");

        //调用静态方法：private static void showDesc()

        Method showDesc = personClass.getDeclaredMethod("showDesc");

        showDesc.setAccessible(true);
        //调用的运行时类中的方法若没有返回值，则invoke()返回null
        Object returnValue1 = showDesc.invoke(Person.class);
//        Object returnValue1 = showDesc.invoke(null);
        System.out.println(returnValue1);//null

    }

    /*
    如何调用运行时类的指定构造器
     */
    @Test
    public void test4() throws Exception{
        Class<Person> personClass = Person.class;
        //private Person(String name)
        /*
        获取指定的构造器
        getDeclaredConstructor()：参数--指明构造器的参数列表
         */
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);

        //保证此构造器是可访问的
        constructor.setAccessible(true);

        //调用此构造器创建运行时类的对象
        Person person = constructor.newInstance("Tom");
        System.out.println(person);

    }
}
