package com.th1024.array;

/*
对象数组
定义类Student，包含三个属性，学号number（int），年纪state（int），成绩score（int）。
创建20个学生对象，学号为1到20，年纪和成绩都有随机数确定。
问题一：打印出三年级（state值为3）的学生信息
问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息

提示：
1.生成随机数：Math.random(),返回值类型为double
    随机数[a,b]公式：int value = (int)(Math.random()*(b-a+1)+a)
2.四舍五入取整：Math.round(double d),返回值类型为long

此代码是对StudentTest.java的改进,将操作数组的功能封装到方法中
 */

public class StudentTest1 {

    public static void main(String[] args) {

        Student1 test = new Student1();
        Student1[] students = test.create(20);

        //遍历学生数组
        test.print(students);

        System.out.println("===================================");

        //打印出三年级（state值为3）的学生信息
        test.infoOfState(students,3);

        System.out.println("===================================");

        //
        //使用冒泡排序按学生成绩排序，并遍历所有学生信息
        test.sortOfScore(students);
        test.print(students);

    }
}

class Student1{

    int number;//学号
    int state;//年级
    int score;//成绩

    //创建对象数组
    public Student1[] create(int length){
        Student1[] students = new Student1[length];//声明对象数组

        for (int i = 0; i < students.length; i++) {

            students[i] = new Student1();//为数组中的元素创建对象

            //给students对象属性赋值
            students[i].number = i + 1;//学号
            students[i].state = (int)(Math.random()*(6-1+1)+1);//年级[1.6]
            students[i].score = (int)(Math.round(Math.random()*(100+1)));//成绩[0,100]

        }
        return students;
    }

    //显示学生信息的方法
    public String info(){
        return "学号：" + number + "\t" + "年级：" + state + "\t" + "成绩：" + score;
    }

    //显示学生数组信息
    public void print(Student1[] students){
        for (int i = 0; i < students.length; i++) {

            System.out.println(students[i].info());
        }
    }

    //显示某一年级信息
    public void infoOfState(Student1[] students, int state){

        for (int i = 0; i < students.length; i++) {

            if(students[i].state == state){
                System.out.println(students[i].info());
            }
        }

    }

    //使用冒泡排序按学生成绩排序，并遍历所有学生信息
    public void sortOfScore(Student1[] students){

        Student1 temp;

        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].score > students[j+1].score){
                    temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                }
            }
        }
    }

}

