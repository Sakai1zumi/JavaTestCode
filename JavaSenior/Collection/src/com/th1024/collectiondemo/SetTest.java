package com.th1024.collectiondemo;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Set接口：存储无序的、不可重复的数据 --->相当于数学“集合”的概念
 *
 *  HashSet：作为Set接口的主要实现类，线程不安全的，可以存储null值
 *      LinkedHashSet：作为HashSet的子类：遍历其内部数据时，可以按照添加的顺序遍历
 *  TreeSet：可以按照添加对象的指定属性，进行排序
 *
 *  Set接口没有额外定义新的方法，使用的都是Collection中定义的方法
 *
 *  要求：
 *      1. 向Set（主要指：HashSet、LinkedHashSet）中添加数据，其所在类一定要重写hashCode()和equals()
 *      2. 重写的hashCode()和equals()尽可能保持一致：相等的对象必须具有相等的散列码
 *
 *
 * @author TuHong
 * @create 2021-01-31 13:18
 */
public class SetTest {

    /*
    一、Set：无序的、不可重复的数据
    以HashSet为例说明
    1. 无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的

    2. 不可重复性：保证添加的元素按照equals()判断时，不能返回true。即相同的元素只能添加一个

    二、添加元素的过程：以HashSet为例
        向HashSet中添加元素a，首先调用元素a所在类的hashcode()，计算元素a的哈希值，
        此哈希值通过某种算法计算出在HashSet底层数组中的存放位置（即为索引位置），判断数组此位置上是否有元素

        有其他元素b（或以链表形式存在的多个元素）：

            比较元素a与元素b的哈希值：

                相同：调用元素a所在类的equals()，
                    返回结果为true，元素a添加失败
                    返回结果为false，元素a添加成功

        说明：对于上面的情况，元素a与已经存在指定索引位置上的数据以链表的形式存在
        JDK7：元素a放在数组中，执行原来的元素
        JDK8：原来的元素放在数组中，指向元素a
        总结：七上八下

        没有：元素a添加成功

    HashSet底层：数组 + 链表

     */
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(new Person("Tom",12));
        set.add(124);
        set.add(123);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据的前一个数据和后一个数据
    //优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(new Person("Tom",12));
        set.add(124);
        set.add(123);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
