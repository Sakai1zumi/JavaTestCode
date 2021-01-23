package com.oop.exer;

public class CylinderTest {

    public static void main(String[] args) {

        Cylinder cylinder = new Cylinder();

        cylinder.setRadius(5);
        cylinder.setLength(10);

        double area = cylinder.findArea();
        System.out.println("圆柱的表面积为：" + area);
        double volume = cylinder.findVolume();
        System.out.println("圆柱的体积为：" + volume);
    }
}
