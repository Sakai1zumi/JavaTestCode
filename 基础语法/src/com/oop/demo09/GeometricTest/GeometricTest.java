package com.oop.demo09.GeometricTest;

/*
定义三个类,父类GeometricObject代表几何形状，子类Circle代表圆形，MyRectangle代表矩形。
定义一个测试类GeometricTest，编写equalsArea方法测试两个对象的面积是否相等（注意方法参数类型，利用动态绑定技术），
编写displayGeometricObject方法显示对象的面积（注意方法的参数类型，利用动态绑定技术）。
 */

public class GeometricTest {

    public static void main(String[] args) {

        GeometricTest test = new GeometricTest();

        Circle c1 = new Circle("white",1.0,3.0);
        Circle c2 = new Circle("red",1.0,2.3);

        test.displayGeometricObject(c1);
        test.displayGeometricObject(c2);
        System.out.println(test.equalsArea(c1,c2));

        MyRectangle rectangle = new MyRectangle("blue",1.0,3.0,4.0);

        test.displayGeometricObject(rectangle);
    }

    //测试两个对象面积是否相等
    public boolean equalsArea(GeometricObject obj1, GeometricObject obj2) {
        return obj1.findArea() == obj2.findArea();
    }

    //显示对象的面积
    public void displayGeometricObject(GeometricObject obj){
        System.out.println("面积为：" + obj.findArea());
    }

}
