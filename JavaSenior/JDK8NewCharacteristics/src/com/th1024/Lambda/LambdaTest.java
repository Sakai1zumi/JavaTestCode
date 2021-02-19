package com.th1024.Lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式使用举例
 *
 * @author TuHong
 * @create 2021-02-18 14:25
 */
public class LambdaTest {

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

        Runnable r2 = () -> System.out.println("测试2");

        r2.run();
    }

    @Test
    public void test2(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare1 = com1.compare(1, 2);
        System.out.println(compare1);

        System.out.println("**********************");
        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);

        int compare2 = com2.compare(3, 2);
        System.out.println(compare2);

        System.out.println("**********************");
        //方法引用
        Comparator<Integer> com3 = Integer :: compare;

        int compare3 = com3.compare(3, 4);
        System.out.println(compare3);
    }
}
