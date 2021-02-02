package com.th1024;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections：操作Collection和Map的工具类
 *
 * 面试题：Collection和Collections的区别
 *
 * @author TuHong
 * @create 2021-02-01 17:52
 */
public class CollectionsTest {

    /*
    Collections类中提供了多个synchronizedXxx()方法，
    该方法可使将指定集合包装成线程同步的集合，
    从而可以解决多线程并发访问集合时的线程安全问题
     */
    @Test
    public void test3(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(100);
        list.add(0);
        list.add(67);

        //反回的list1即为线程安全的list
        List list1 = Collections.synchronizedList(list);
    }

    /*
    reverse(List)：反转List中元素的顺序
    shuffle(List)：对List集合元素进行随机排序
    sort(List)：根据元素的自然顺序对指定List集合元素按升序排序
    sort(List, Comparator)：根据指定的Comparator产生的顺序对List集合元素进行排序
    swap(List, int, int)：将指定list集合中的 i 处元素和 j 处元素进行交换

    Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
    Object max(Collection, Comparator)：根据Comparator指定的顺序，返回给定集合中的最大元素
    Object min(Collection)
    Object min(Collection, Object)
    int frequency(Collection, Object)：返回指定集合中指定元素的出现次数
    void copy(List dest, List src)：将src中的内容复制到dest中
    boolean replaceAll(List list, Object oldVal, Object newVal)：使用新值替换List对象的所有旧值
     */
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(100);
        list.add(0);
        list.add(67);

        //异常：IndexOutOfBoundsException: Source does not fit in dest
//        List dest = new ArrayList();
//
//        Collections.copy(dest,list);
        //正确方式
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);
    }

    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(100);
        list.add(0);
        list.add(67);

        System.out.println(list);

//        Collections.reverse(list);
//        Collections.shuffle(list);
//        Collections.sort(list);
//        Collections.swap(list,1,2);
        System.out.println(Collections.frequency(list, 765));

        System.out.println(list);


    }

}
