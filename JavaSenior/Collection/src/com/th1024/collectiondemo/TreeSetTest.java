package com.th1024.collectiondemo;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author TuHong
 * @create 2021-01-31 15:15
 */
public class TreeSetTest {

    /*
    1. 向TreeSet中添加的数据，要求是相同类的对象
    2. 两种排列方式：自然排序（实现Comparable接口）和定制排序（实现Comparator接口）

    3. 自然排序中，比较两个对象是否相同的标准为：compareTo()返回是否为0，0则认为是相同，不再是equals()
    4. 定制排序中，比较两个对象是否相同的标准为：compare()返回是否为0，0则认为是相同，不再是equals()
     */
    @Test
    public void test1() {

        TreeSet set = new TreeSet();

        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new Person("Tom",12));

        //举例一
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二
        set.add(new Person("Tom", 10));
        set.add(new Person("Jerry", 32));
        set.add(new Person("Jim", 22));
        set.add(new Person("Mike", 62));
        set.add(new Person("Jack", 18));
        set.add(new Person("Jack", 56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Comparator com = new Comparator() {
            //按照年龄从小到大排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                } else {
                    throw new RuntimeException("类型不一致");
                }
            }
        };

        TreeSet set = new TreeSet(com);

        set.add(new Person("Tom", 10));
        set.add(new Person("Jerry", 32));
        set.add(new Person("Mary", 22));
        set.add(new Person("Jim", 22));
        set.add(new Person("Mike", 62));
        set.add(new Person("Jack", 18));
        set.add(new Person("Jack", 56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
