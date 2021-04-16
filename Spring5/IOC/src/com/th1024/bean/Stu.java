package com.th1024.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author TuHong
 * @create 2021-04-08 15:05
 */
public class Stu {
    private String[] courses;
    private List<String> list1;
    private List<Course> list2;
    private Map<String,String> maps;
    private Set<String> sets;

    public Stu() {
    }


    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }


    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public List<String> getList1() {
        return list1;
    }

    public void setList1(List<String> list1) {
        this.list1 = list1;
    }

    public List<Course> getList2() {
        return list2;
    }

    public void setList2(List<Course> list2) {
        this.list2 = list2;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "courses=" + Arrays.toString(courses) +
                ", list1=" + list1 +
                ", list2=" + list2 +
                ", maps=" + maps +
                ", sets=" + sets +
                '}';
    }
}
