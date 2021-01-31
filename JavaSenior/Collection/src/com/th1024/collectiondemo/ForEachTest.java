package com.th1024.collectiondemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * JDK5.0新增了foreach循环，用于遍历集合、数组
 *
 * @author TuHong
 * @create 2021-01-31 10:24
 */
public class ForEachTest {

    @Test
    public void test3(){
        String[] arr = new String[]{"MM","MM","MM"};

        //方式一：普通for赋值
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//        }

        //方式二：增强for循环
        for(String s : arr){
            s = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5};

        //for(数组元素的类型 局部变量 : 数组对象)
        for(int i : arr){
            System.out.println(i);
        }
    }

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",23));

        //for(集合元素的类型 局部变量 : 集合对象)
        //内部仍然调用了迭代器
        for(Object obj : coll){
            System.out.println(obj);
        }
    }
}
