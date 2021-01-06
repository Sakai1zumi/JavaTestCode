package com.oop.demo01;

/*
1.定义一个Circle类，包含一个double型的radius属性代表元的半径，
  一个findArea()方法返回圆的面积。
2.定义一个类PassObject，在类中定义一个方法printAreas()，该方法的定义如下：
  public void printAreas (Circle c,int time)
  在printAreas方法中打印输出1到time之间的每个整数半径值，以及对应的面积。
  例如，time为5，则输出半径1，2，3，4，5，以及对应的圆面积。
3.在main方法中调用printAreas()方法，调用完毕后输出当前半径值。

考察值传递的使用
 */

public class Demo06 {

    public static void main(String[] args) {

        PassObject passObject = new PassObject();
        Circle circle = new Circle();

        passObject.printAreas(circle,5);

        System.out.println("now the radius is:" + (++circle.radius));

    }

}

class Circle {

    double radius;//表示圆的半径

    public double findArea(double r){

        return (Math.PI * r * r);
    }
}

class PassObject {

    public void printAreas(Circle c,int time){

        System.out.println("Radius\tArea");

        int i;
        for ( i = 1; i <= time; i++) {
            c.radius = i;
            System.out.print(c.radius + "\t\t" + c.findArea(i));
            System.out.println();
        }


    }

}
