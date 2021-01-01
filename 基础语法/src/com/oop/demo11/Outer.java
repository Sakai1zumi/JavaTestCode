package com.oop.demo11;

import javax.sound.midi.Soundbank;

public class Outer {

    private static int id = 10;

    public void out(){
        System.out.println("这是外部类的方法");
    }

    public  class Inner{

        public void in(){
            System.out.println("这是内部类的方法");
        }

        //获得外部类的私有属性
        //内部类可访问static属性，但是static内部类不能访问外部非static属性
        public void getId(){
            System.out.println(id);
        }
    }



}
