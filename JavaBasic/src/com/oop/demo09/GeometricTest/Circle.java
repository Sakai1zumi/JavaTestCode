package com.oop.demo09.GeometricTest;

public class Circle extends GeometricObject {

    private double radius;

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //子类对抽象方法的重写
    public double findArea(){
        return Math.PI * radius * radius;
    }
}
