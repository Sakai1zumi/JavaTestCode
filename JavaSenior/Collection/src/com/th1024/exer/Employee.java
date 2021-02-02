package com.th1024.exer;

/**
 * 定义一个Employee类
 * 该类包含：private成员变量name，age，birthday，其中birthday为MyDate类的对象
 * 并为每一个属性定义getter，setter方法
 * 重写toString()方法输出那么，age，birthday
 *
 * @author TuHong
 * @create 2021-02-01 10:53
 */
public class Employee implements Comparable{

    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    //按照name排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee employee = (Employee) o;
            return this.name.compareTo(employee.name);
        }else{
            throw new RuntimeException("输入数据类型不一致");
        }
    }
}
