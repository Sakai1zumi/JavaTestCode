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
 */

public class StudentTest {

    public static void main(String[] args) {

        Student[] students = new Student[20];//创建对象数组

        for (int i = 0; i < students.length; i++) {

            students[i] = new Student();//为数组中的元素创建对象

            //给students对象属性赋值
            students[i].number = i + 1;//学号
            students[i].state = (int)(Math.random()*(6-1+1)+1);//年纪[1.6]
            students[i].score = (int)(Math.round(Math.random()*(100+1)));//成绩[0,100]

        }

        //遍历学生数组
        for (int i = 0; i < students.length; i++) {

            System.out.println(students[i].info());
        }
        System.out.println("===================================");

        //打印出三年级（state值为3）的学生信息
        for (int i = 0; i < students.length; i++) {

            if(students[i].state == 3){
                System.out.println(students[i].info());
            }
        }
        System.out.println("===================================");

        Student temp = new Student();
        //使用冒泡排序按学生成绩排序，并遍历所有学生信息
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].score > students[j+1].score){
                    temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                }
            }
        }
        //遍历
        for (int i = 0; i < students.length; i++) {

            System.out.println(students[i].info());
        }


    }
}

class Student{

    int number;//学号
    int state;//年级
    int score;//成绩

    //显示学生信息的方法
    public String info(){
        return "学号：" + number + "\t" + "年级：" + state + "\t" + "成绩：" + score;
    }

}

