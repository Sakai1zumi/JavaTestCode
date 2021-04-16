package com.th1024.bean;

/**
 * @author TuHong
 * @create 2021-04-08 15:14
 */
public class Course {
    private String name;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
