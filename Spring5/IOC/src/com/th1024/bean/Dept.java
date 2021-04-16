package com.th1024.bean;

/**
 * @author TuHong
 * @create 2021-04-07 22:00
 */
public class Dept {

    private String name;

    public Dept() {
    }

    public Dept(String name) {
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
        return "Dept{" +
                "name='" + name + '\'' +
                '}';
    }
}
