package com.oop.demo08.exer;


public class GeometricObjectTest{

    public static void main(String[] args) {

        Circle c1 = new Circle(1.0);
        Circle c2 = new Circle("black",1.0,2.0);

//        if(c1.color == c2.color){
//            System.out.println("颜色相等");
//        }else{
//            System.out.println("颜色不相等");
//        }

        //判断颜色是否相等
        System.out.println("颜色是否相等：" + c1.getColor().equals(c2.getColor()));

        System.out.println("半径是否相等：" + c1.equals(c2));

        System.out.println("c1:" + c1.toString() + "\n" + "c2:" + c2.toString());

    }

}


class GeometricObject{

    protected String color;
    protected double weight;

    public GeometricObject() {
        this.color = "white";
        this.weight = 1.0;
    }

    public GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class Circle extends GeometricObject{

    private double radius;

    public Circle() {
        this.color = "white";
//        this.weight = 1.0;
//        this.radius = 1.0;
    }

    public Circle(double radius) {
//        this.color = "white";
//        this.weight = 1.0;
        this.radius = radius;
    }

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

    public double findArea(){
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    public String toString(){
        return "Circle{color='" + this.color + "'" + ", weight=" + this.weight + ", radius=" + this.radius + "}";
    }
}
