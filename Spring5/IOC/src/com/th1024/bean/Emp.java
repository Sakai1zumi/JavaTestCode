package com.th1024.bean;

/**
 * @author TuHong
 * @create 2021-04-07 22:01
 */
public class Emp {

    private String name;
    private String gender;
    private Dept dept;

    public Emp() {
    }

    public Emp(String name, String gender, Dept dept) {
        this.name = name;
        this.gender = gender;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
