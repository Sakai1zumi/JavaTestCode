package com.th1024.bean;

import org.springframework.stereotype.Component;

/**
 * 被增强类
 * @author TuHong
 * @create 2021-04-09 14:46
 */

@Component
public class User {

    public void test(){

//        int i = 10/0;

        System.out.println("User-test");
    }
}
