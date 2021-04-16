package com.th1024.bean;

/**
 * @author TuHong
 * @create 2021-04-07 21:24
 */
public class User {

    private String name;
    private String gender;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User() {
    }

    public User(String name, String gender) {
        this.name = name;
        this.gender = gender;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public void test(){
        System.out.println("test方法");
    }
}
