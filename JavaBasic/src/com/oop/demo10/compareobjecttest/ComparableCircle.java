package com.oop.demo10.compareobjecttest;

/*
定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。
在ComparableCircle类中给出接口方法compareTo的实现体，用来比较两个圆的半径大小

* 比较两个对象的大小
 */

public class ComparableCircle extends Circle implements CompareObject{

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {

        if(this == o) return 0;

        if(o == null || o.getClass() != this.getClass())  return 0;//throw new RuntimeException("传入的数据类型不匹配");

            ComparableCircle circle = (ComparableCircle) o;//先强制转换类型

            //方式一
//            if(this.getRadius() == circle.getRadius()){
//                return 0;
//            }else if(this.getRadius() > circle.getRadius()){
//                return 1;
//            }else{
//                return -1;
//            }
            //方式二
            //当属性radius声明为Double类型时，可以调用包装类的方法
            return this.getRadius().compareTo(circle.getRadius());
        }

    }

