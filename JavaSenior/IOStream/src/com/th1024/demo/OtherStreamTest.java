package com.th1024.demo;

import org.junit.Test;

import java.io.*;

/**
 * 其它流的使用
 *
 * 1. 标准的输入、输出流
 *
 * 2. 打印流
 *
 * 3. 数据流
 *
 * @author TuHong
 * @create 2021-02-04 23:27
 */
public class OtherStreamTest {

    /*
    标准的输入、输出流
    System.in：标准的输入流，默认从键盘输入
    System.out：标准的输出流，默认从控制台输出

    System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新制定输入和输出的流

    练习：
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作
    直至输入"e"或"exit"退出

    方法一：使用Scanner实现，调用next()转换为字符串
    方法二：使用System.in实现，System.in --> 转换流 --> BufferedReader的readLine()
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            String data;
            while(true){
                System.out.println("请输入字符串：");
                data = br.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String toUpperCase = data.toUpperCase();
                System.out.println(toUpperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
    打印流：
    PrintStream、PrintWriter
     */
    @Test
    public void test1(){
        PrintStream ps = null ;
        try {
            FileOutputStream fos = new FileOutputStream(new File("F:\\java\\text.txt"));
            //创建打印输出流,设置为自动刷新模式(写入换行符或字节'\n'时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true );
            if (ps != null ) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }

            for (int i= 0; i<= 255;i++) { //输出 ASCII字符
                    System.out.print((char)i);
                    if (i% 50 == 0) {//每50个数据一行
                        System.out.println(); //换行
                    }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } finally{
            if (ps != null) {
                ps.close();
            }
        }
    }

    /*
    数据流：DataInputStream和DataOutputStream
    作用：用于读取或写出基本数据类型的变量或字符串
     */
    @Test
    public void test2(){
        DataOutputStream dos= null ;
        try {//创建连接到指定文件的数据输出流对象
            dos = new DataOutputStream(new FileOutputStream("destData.dat"));
            dos.writeUTF("我爱北京天安门"); //写UTF字符串
            dos.writeBoolean(false); // 写入布尔值
            dos.writeLong(1234567890L); //写入长整数
            System.out.println("写文件成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally { //关闭流对象
            try{
                if (dos != null ) {
                //关闭过滤流时,会自动关闭它包装的底层节点流
                    dos.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    将文件中存储的基本数据类型变量和字符串读取到内存，保存在变量中
    注意点：读取数据的顺序需与写入文件时，保存的数据的顺序一致
     */
    @Test
    public void test3(){
        DataInputStream dis = null;
        try {//创建连接到指定文件的数据输入流对象
            dis = new DataInputStream(new FileInputStream("destData.dat"));

            String s = dis.readUTF();//读取UTF字符串
            boolean b = dis.readBoolean();//读取布尔值
            long l = dis.readLong();//读取长整数

            System.out.println(s + b + l);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//关闭流对象
            if(dis != null){
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

