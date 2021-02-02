package com.th1024.mapdemo;

import java.util.Objects;

/**
 * @author TuHong
 * @create 2021-01-30 13:55
 */
public class Person implements Comparable{

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Person.equals()");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //按照姓名字母从小到大排序，年龄从小到大排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person person = (Person) o;
//            return this.name.compareTo(person.name);
            int compare = this.name.compareTo(person.name);
            if(compare != 0){
                return compare;
            }else{
                return Integer.compare(this.age,person.age);
            }
        }else{
            throw new RuntimeException("类型不一致");
        }
    }
}
