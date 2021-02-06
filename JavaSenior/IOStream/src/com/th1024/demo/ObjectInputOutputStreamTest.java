package com.th1024.demo;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1. ObjectInputStream和ObjectOutputStream
 *
 * 2. 作用：用于存储和读取基本数据类型数据或对象的处理流，它的强大之处就是可以把Java中的对象写入到数据源中，也可以把对象从数据源中还原回来
 *
 * 3. 类需满足要求方可序列化
 *
 * @author TuHong
 * @create 2021-02-05 14:21
 */
public class ObjectInputOutputStreamTest {

    /*
    序列化的过程：将内存中的Java对象保存到磁盘中过通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            //1.
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //2.
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("张三",12));
            oos.flush();

            oos.writeObject(new Person("张三",12,new Account(5000)));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){//3.
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化的过程：将磁盘文件中的对象还原为内存中的一个Java对象
    使用ObjectInputStream实现
     */
    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object o = ois.readObject();
            String str = (String) o;

            Person p1 = (Person)ois.readObject();
            Person p2 = (Person)ois.readObject();

            System.out.println(str);
            System.out.println(p1);
            System.out.println(p2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
