package com.oop.exer;

public class Cylinder extends Circle{

    private double length;

    public Cylinder() {
        this.length = 1.0;//数据为double型
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume(){
        return super.findArea() * this.length;
    }

    @Override
    public double findArea() {//返回圆柱表面积
        return 2 * super.findArea() + 2 * Math.PI * getRadius() * getLength();
    }
}
