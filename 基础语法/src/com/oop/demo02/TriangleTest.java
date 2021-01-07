package com.oop.demo02;

public class TriangleTest {

    public static void main(String[] args) {

        Triangle t = new Triangle();

        t.setBase(10);
        t.setHeight(10);

        double area = new TriangleTest().findArea(t.getBase(),t.getHeight());
        System.out.println(area);

        Triangle t1 = new Triangle(5,5);
        double area1 = new TriangleTest().findArea(t1.getBase(),t1.getHeight());
        System.out.println(area1);


    }

    public double findArea(double base,double height){
        double area;

        return area = base * height / 2;
    }

}
