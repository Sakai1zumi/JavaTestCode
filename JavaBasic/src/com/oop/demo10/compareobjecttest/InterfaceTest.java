package com.oop.demo10.compareobjecttest;

public class InterfaceTest {

    public static void main(String[] args) {

        ComparableCircle c1 = new ComparableCircle(1.0);
        ComparableCircle c2 = new ComparableCircle(2.0);

        int compareValue = c1.compareTo(c2);

        if(compareValue == 0){
            System.out.println("c1和c2的半径相等");
        }else if(compareValue > 0){
            System.out.println("c1的半径大于c2的半径");
        }else{
            System.out.println("c1的半径小于c2的半径");
        }

    }
}
