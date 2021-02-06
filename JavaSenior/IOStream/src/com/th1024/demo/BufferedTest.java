package com.th1024.demo;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *
 * 1. 缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2. 作用：提高流的读取、写入速度
 *    原因：内部提供了一个缓冲区
 *
 * 3. 处理流，就是“套接”在已有的流的基础上
 *
 * @author TuHong
 * @create 2021-02-04 16:24
 */
public class BufferedTest {

    /*
    使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void test3(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //1. 创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));
            //读写操作
            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//            }
            //方式二：使用String
            String data;
            while((data = br.readLine()) != null){
                //方法一：
//                bw.write(data + "\n");//data中不包含换行符
                //方法二：
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//3. 流资源的关闭
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    实现文件复制的方法
     */
    @Test
    public void test2(){
        long start = System.currentTimeMillis();

        String srcPath = "F:\\工具人\\The.Silence.of.the.Lambs.1991.1080p.BluRay.H264.AAC-RARBG\\The.Silence.of.the.Lambs.1991.1080p.BluRay.H264.AAC-RARBG.mp4";
        String destPath = "F:\\工具人\\The.Silence.of.the.Lambs.1991.1080p.BluRay.H264.AAC-RARBG\\(copy)The.Silence.of.the.Lambs.1991.1080p.BluRay.H264.AAC-RARBG.mp4";
//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";
        copyFileWithBuffered(srcPath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为：" + (end - start));//16110--4117
    }
    public void copyFileWithBuffered(String srcPath, String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1. 创建File类的对象，指明读入和写出的文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2. 创建输入流和输出流的对象
            //2.1 创建节点流对象
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 创建缓冲流对象
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3. 数据的读入和写出操作
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 流资源的关闭
            //要求：先关闭外层缓冲流，再关闭内层节点流
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    使用缓冲流实现非文本文件的复制
     */
    @Test
    public void test1(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1. 创建File类的对象，指明读入和写出的文件
            File srcFile = new File("wallhaven-48rwdj.jpg");
            File destFile = new File("wallhaven-48rwdj2.jpg");

            //2. 创建输入流和输出流的对象
            //2.1 创建节点流对象
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 创建缓冲流对象
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3. 数据的读入和写出操作
            byte[] buffer = new byte[5];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 流资源的关闭
            //要求：先关闭外层缓冲流，再关闭内层节点流
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层缓冲流的同时，内层节点流也会自动关闭，故关闭内层节点流的操作可以省略
//        fos.close();
//        fis.close();
        }
    }
}
