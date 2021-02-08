package com.th1024.demo1;

import java.io.Serializable;

/**
 * @author TuHong
 * @create 2021-02-07 15:13
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breathe(){
        System.out.println("呼吸");
    }

    public void eat(){
        System.out.println("进食");
    }
}
