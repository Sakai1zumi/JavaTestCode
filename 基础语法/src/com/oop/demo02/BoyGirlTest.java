package com.oop.demo02;

public class BoyGirlTest {

    public static void main(String[] args) {

        Boy boy = new Boy("罗密欧", 21);
        Girl girl = new Girl("王冰冰", 18);
        Girl girl1 = new Girl("祝英台",19);

        boy.shout();

        System.out.println();

        girl.marry(boy);

        System.out.println();

        int compare = girl.compare(girl1);
        if(compare > 0){
            System.out.println(girl.getName() + "大");
        }else if(compare < 0){
            System.out.println(girl1.getName() + "大");
        }else{
            System.out.println("一样大");
        }

    }
}
