package com.th1024.demo;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author TuHong
 * @create 2021-02-07 13:35
 */
public class ClassLoaderTest {

    /*
    Properties：用来读取配置文件
     */
    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        //读取配置文件的方式一：
        //此时的文件默认在当前的Module下
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);

        //读取配置文件的方式二：
        //此时的文件默认在当前Module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        System.out.println(user);
        System.out.println(password);
    }

    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader parent1 = classLoader.getParent();
        System.out.println(parent1);
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载Java的核心类库，无法加载自定义类
        ClassLoader parent2 = parent1.getParent();
        System.out.println(parent2);
    }
}
