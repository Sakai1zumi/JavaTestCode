package com.th1024.Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 *
 * 1. 举例：(o1,o2) -> Integer.compare(o1,o2);
 *
 * 2. 格式：
 *      ->：Lambda操作符 或 箭头操作符
 *      ->左边：Lambda形参列表（接口中抽象方法的形参列表）
 *      ->右边：Lambda体（重写的抽象方法的方法体）
 *
 * 3. Lambda表达式的使用：6种情况
 *    总结：
 *    ->左边：Lambda形参列表的参数类型可以省略（类型推断）；如果Lambda形参列表只有一个参数，()也可以省略
 *    ->右边：Lambda体应该使用一对{}包裹；如果Lambda体只有一条执行语句（可能是return语句），{}和return都可以省略
 *
 * 4. Lambda表达式的本质：作为函数式接口的实例
 *
 * 5. 如果一个接口中，只声明了一个抽象方法，则此接口称为函数式接口
 *    之前使用匿名实现类表示的现在都可以用Lambda表达式来写
 *    @FunctionalInterface：函数式接口注解
 *
 * @author TuHong
 * @create 2021-02-18 14:49
 */
public class LambdaTest1 {

    //语法格式一：无参，无返回值
    @Test
    public void test1(){
        Runnable r1 = new Runnable(){

            @Override
            public void run() {
                System.out.println("测试1");
            }
        };

        r1.run();

        System.out.println("*****************");

        Runnable r2 = () -> {
            System.out.println("测试2");
        };

        r2.run();


    }

    //语法格式二：Lambda需要一个参数，没有返回值
    @Test
    public void test2(){

        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        con.accept("测试3");

        System.out.println("***************");

        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };

        con1.accept("测试4");
    }

    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test3(){
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };

        con1.accept("测试4");

        System.out.println("****************");

        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };

        con2.accept("测试4");

        ArrayList<String> list = new ArrayList<>();//类型推断

        int[] arr = {1,2,3};//类型推断
    }

    //语法格式四：Lambda若只需要一个参数，参数的小括号可以省略
    @Test
    public void test4(){
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };

        con1.accept("测试4");

        System.out.println("*****************");

        Consumer<String> con2 = s -> {
            System.out.println(s);
        };

        con2.accept("测试4");
    }

    //语法格式五：Lambda需要两个或以上的参数，多条执行语句，并可以有返回值
    @Test
    public void test5(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        System.out.println(com1.compare(1, 2));

        System.out.println("***********************");

        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com2.compare(3, 2));
    }

    //语法格式六：当Lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test6(){
        Comparator<Integer> com1 = (o1,o2) -> {
                return o1.compareTo(o2);
        };

        System.out.println(com1.compare(1, 2));

        System.out.println("***********************");

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);

        System.out.println(com2.compare(3,2));
    }

}
