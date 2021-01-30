package com.th1024.collectiondemo;

import org.junit.Test;

import java.util.*;

/**
 * 一、集合框架的概述
 *
 * 1. 集合、数组都是对多个数据进行存储操作的结构，称为Java的容器
 *
 * 2.1 数组在存储多个数据方面的特点：
 *      >一旦初始化，长度就确定了
 *      >一旦定义好，元素类型就确定了
 *
 * 2.2 数组在存储多个数据方面的缺点：
 *      >初始化之后长度不可修改
 *      >数组中提供的方法非常有限
 *      >数组存储数据的特点：有序、可重复。对于无序、不可重复的存储需求，不能满足
 *
 * 二、集合框架
 *      |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据  -->"动态"数组
 *              |----ArrayList、LinkedList、Vector
 *          |----Set接口：存储无序的、不可重复的数据  -->高中讲的"集合"
 *              |----HashSet、LinkedHashSet、TreeSet
 *      |----Map接口：双列集合，用来存储一堆(key - value)一对的数据  -->函数：y = f(x)
 *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *  说明：向Collection接口的实现类的对象中添加数据obj时，要求obj所在类重写equals()
 *
 * @author TuHong
 * @create 2021-01-29 16:28
 */
public class CollectionTest {

    @Test
    public void test5(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",23));

        //hashCode()：返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //集合 ---> 数组：toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //拓展：数组 ---> 集合：Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2

        //iterator()：返回Iterator接口的实例，用于遍历集合元素
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",23));

        //retainAll(Collection coll)：获取当前集合和coll集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123,456);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //equals(Object obj)：判断当前集合和形参集合是否完全一致
        Collection coll1 = new ArrayList();

        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("Tom"));
        coll1.add(false);
        coll1.add(new Person("Jerry",23));

        System.out.println(coll.equals(coll1));

    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",23));

        //remove(Object obj)：从当前集合中移除obj元素
        coll.remove(1234);//返回true删除成功，返回false删除失败
        System.out.println(coll);

        coll.remove(new Person("Jerry",23));
        System.out.println(coll);

        //removeAll(Collection coll)：从当前集合中移除coll中的所有元素
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",23));

        //contains(Object obj)：判断当前集合中是否包含obj
        //使用contains()判断时，会调用obj对象所在类中的equals()进行比较
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));//true--调用equals()比较内容
        System.out.println(coll.contains(new Person("Jerry",23)));//false--重写equals()-->true

        //containsAll(Collection coll)：判断形参coll中的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123,4567);
        System.out.println(coll.containsAll(coll1));

    }

    @Test
    public void test1(){

        Collection coll = new ArrayList();

        //add(Object e)
        coll.add("AA");
        coll.add("BB");
        coll.add(213);
        coll.add(new Date());

        //size():获取添加的元素的个数
        System.out.println(coll.size());

        //addAll(Collection coll):将coll集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size());
        System.out.println(coll);

        //clear():清空集合元素
        coll.clear();

        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());
    }
}
