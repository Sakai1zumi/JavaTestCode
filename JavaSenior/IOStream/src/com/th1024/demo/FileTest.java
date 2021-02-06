package com.th1024.demo;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 *
 * 1. File类的一个对象，代表一个文件或一个文件目录（俗称：文件夹）
 * 2. File类定义在java.io包下
 * 3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 *    并未涉及到写入或读取文件内容的操作，如需实现写入或读取，必须使用IO流完成
 * 4. 后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点"
 *
 * @author TuHong
 * @create 2021-02-02 21:32
 */
public class FileTest {

    /*
    创建硬盘对应的文件或文件目录
    public boolean createNewFile()：创建文件，若文件存在，则不创建，返回false
    public boolean mkdir()：创建文件目录，如果此文件目录存在，就不创建了，如果此文件目录的上层不存在，也不创建
    public boolean mkdirs()：创建文件目录 。如果上层文件目录不存在，一并创建

    删除硬盘中的文件或文件夹
    public boolean delete()：删除文件或文件夹
    注意事项：Java中的删除不走回收站
     */
    @Test
    public void test7(){
        //文件目录的创建
        File file1 = new File("F:\\java\\java1\\java3");
        boolean mkdir1 = file1.mkdir();
        if(mkdir1) System.out.println("创建成功1");

        File file2 = new File("F:\\java\\java2\\java4");
        boolean mkdir2 = file2.mkdirs();
        if(mkdir2) System.out.println("创建成功2");
    }
    @Test
    public void test6() throws IOException {
        //文件的创建
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }else{//文件存在
            file1.delete();
            System.out.println("删除成功");
        }
    }

    /*
    public boolean isDirectory()：判断是否是文件目录
    public boolean isFile()：判断是否文件
    public boolean exists()：判断是否存在
    public boolean canRead ()：判断是否可读
    public boolean canWrite()：判断是否可写
    public boolean isHidden()：判断是否隐藏
     */
    @Test
    public void test5(){
        File file1 = new File("hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        File file2 = new File("F:\\java\\IdeaProjects\\JavaSenior");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }

    /*
    public boolean renameTo(File dest)：把文件重命名为指定的文件路径
    以file1.renameTo(file2)为例，返回true：file1需在硬盘中存在，且file2不存在
     */
    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        File file2 = new File("F:\\java\\hi.txt");

        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);
    }

    /*
    public String getAbsolutePath()：获取绝对路径
    public String getPath()：获取路径
    public String getName()：获取名称
    public String getParent()：获取上层文件目录路径，若无，返回 null
    public long length()：获取文件长度（即：字节数），不能获取目录的长度
    public long lastModified()：获取最后一次的修改时间，毫秒值

    如下的两个方法适用于文件目录
    public String[] list()：获取指定目录下的所有文件或者文件目录的名称数组
    public File[] listFiles()：获取指定目录下的所有文件或者文件目录的File数组
     */
    @Test
    public void test3(){
        File file = new File("F:\\java\\IdeaProjects\\JavaSenior");

        String[] list = file.list();
        for(String s : list){
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }
    }
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("F:\\java\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }

    /*
    1. 如何创建File类的实例
        File(String pathname)
        File(String parentPath, String childPath)
        File(File parentFile, String childPath)

    2. 路径
    相对路径：相较于某个路径下，指明的路径
    绝对路径：包含盘符在内的文件或文件目录的路径

    3. 路径分隔符
    window：\\
    unix：/
     */
    @Test
    public void test1(){
        //构造器1
        File file1 = new File("hello.txt");//相对于当前module
        File file2 = new File("F:\\java\\IdeaProjects\\JavaSenior\\IOStream\\he.txt");
        System.out.println(file1);
        System.out.println(file2);

        //构造器2
        File file3 = new File("F:\\java\\IdeaProjects","JavaSenior");
        System.out.println(file3);

        //构造器3
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }

}
