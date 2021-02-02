package com.th1024.mapdemo;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Properties：常用来处理配置文件，key和value都是String类型
 *
 * @author TuHong
 * @create 2021-02-01 17:43
 */
public class PropertiesTest {

    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);//加载流对应的文件

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");

        System.out.println(name);
        System.out.println(password);
    }
}
