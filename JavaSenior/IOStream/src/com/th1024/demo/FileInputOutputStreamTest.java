package com.th1024.demo;

import org.junit.Test;

import java.io.*;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 * 1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 * 2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt...)，使用字节流处理
 *
 * @author TuHong
 * @create 2021-02-04 14:50
 */
public class FileInputOutputStreamTest {

    /*
    指定路径下的文件的复制
     */
    @Test
    public void test3(){
        long start = System.currentTimeMillis();

        String srcPath = "F:\\工具人\\The.Silence.of.the.Lambs.1991.1080p.BluRay.H264.AAC-RARBG\\The.Silence.of.the.Lambs.1991.1080p.BluRay.H264.AAC-RARBG.mp4";
        String destPath = "F:\\工具人\\The.Silence.of.the.Lambs.1991.1080p.BluRay.H264.AAC-RARBG\\(copy)The.Silence.of.the.Lambs.1991.1080p.BluRay.H264.AAC-RARBG.avi";
//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";
        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为：" + (end - start));//16110
    }
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1. 创建File类的对象，指明读入和写出的文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2. 创建输入流和输出流的对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3. 数据的读入和写出操作
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//4. 流资源关闭
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    实现对图片的复制操作
     */
    @Test
    public void test2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1. 创建File类的对象，指明读入和写出的文件
            File srcFile = new File("wallhaven-48rwdj.jpg");
            File destFile = new File("wallhaven-48rwdj1.jpg");

            //2. 创建输入流和输出流的对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3. 数据的读入和写出操作
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//4. 流资源关闭
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //使用FileInputStream处理文本文件可能出现乱码
    @Test
    public void test1() {
        FileInputStream fis = null;
        try {
            //1. 创建File类的对象，指明读入和写出的文件
            File file = new File("hello.txt");

            //2. 创建输入流和输出流的对象
            fis = new FileInputStream(file);

            //3. 数据的读入或写出操作
            byte[] buffer = new byte[5];//UTF-8中汉字占三个字节，输出乱码
            int len;//记录每次读取的字节的个数
            while((len = fis.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//4. 流资源关闭
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
