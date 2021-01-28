package com.th1024.compare;

import org.junit.Test;

import java.util.Arrays;

/**
 * 1. 说明：Java中的对象，正常情况下，只能进行比较：== 或 ！=
 *
 * 2. Comparable接口的使用
 *
 * @author TuHong
 * @create 2021-01-28 23:05
 */
public class CompareTest {

    /*
    Comparable接口的使用举例：
    1. String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，可比较两个对象的大小
    2. String、包装类重写compareTo(obj)方法，进行了从小到大的排序
    3. 重写compareTo()的规则：
        如果当前对象this大于形参对象obj，则返回正整数，
        如果当前对象this小于形参对象obj，则返回负整数，
        如果当前对象this等于形参对象obj，则返回零
    4. 对于自定义类如需要排序，可实现Comparable接口，重写compareTo()，方法中指明排序方式
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        //
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){

        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("microsoftMouse",43);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
