package com.th1024.exer;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author TuHong
 * @create 2021-02-01 11:45
 */
public class HashSetTest {

    //面试题
    @Test
    public void test1(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);

        set.add(new Person(1001,"CC"));
        System.out.println(set);

        set.add(new Person(1001,"AA"));
        System.out.println(set);
    }
}
