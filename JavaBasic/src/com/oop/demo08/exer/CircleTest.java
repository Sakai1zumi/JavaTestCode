package com.oop.demo08.exer;

//static关键字的应用

public class CircleTest {

    public static void main(String[] args) {
        Circle1 c1 = new Circle1();
        Circle1 c2 = new Circle1();
        Circle1 c3 = new Circle1(1.0);

        System.out.println("c1的id为" + c1.getId());
        System.out.println("c2的id为" + c2.getId());
        System.out.println("c3的id为" + c3.getId());

        System.out.println("创建的圆的个数为" + Circle1.getTotal());
    }



}

class Circle1{

    private double radius;
    private int id;

    public Circle1(){
        id = init++;
        total++;
    }

    public Circle1(double radius) {
        this();
        this.radius = radius;
//        id = init++;
//        total++;
    }

    private static int total;//创建的圆的个数
    private static int init = 1001;//声明为static的属性被多个对象共享

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }

    public double findArea(){
        return Math.PI * radius * radius;
    }

}
