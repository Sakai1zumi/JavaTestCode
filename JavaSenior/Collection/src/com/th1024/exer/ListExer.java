package com.th1024.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 区分list中remove(int index)和remove(Object obj)
 *
 * @author TuHong
 * @create 2021-01-31 11:59
 */
public class ListExer {

    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private static void updateList(List list){
//        list.remove(2);
        list.remove(new Integer(2));
    }
}
