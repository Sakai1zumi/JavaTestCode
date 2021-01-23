package com.oop.demo08.exer;

/*
利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输结束），找出最高分，并输出学生成绩等级。
提示：数组一旦创建，长度就固定不变，所以在前需要知道它的长度。而向量类 java.util.Vector可以根据需要动态伸缩。
创建Vector对象：Vector v=new Vector();
给向量添加元素：v.addElement(Object obj);//obj必须是对象
取出向量中的元素：Object obj =v.elementAt(0);
    注意第一个元素的下标是 0，返回值是 ObjectObject Object Object类型的。 类型的。
计算向量的长度： v.size();
若与最高分相差10分内：A等；20分内：B等；
30分内：C等；其它：D等
 */

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {

    public static void main(String[] args) {
        //1.实例化Scanner对象，获取学生成绩
        Scanner scanner = new Scanner(System.in);

        //2.创建Vector对象，相当于原来的数组
        Vector v = new Vector();

        //3.通过for(;;)或while(true)方式，给Vector中添加数据，输入负数结束
        int maxScore = 0;
        for (;;){
            System.out.print("请输入学生成绩（输入负数结束）：");
            int score = scanner.nextInt();

            //输入为负数时，跳出循环
            if(score < 0){
                break;
            }
            if(score > 100){
                System.out.println("输入数据非法，请重新输入");
                continue;
            }

            //添加操作，v.addElement(Object obj);
//            Integer in = new Integer(score);
            v.addElement(score);//自动装箱

            //4.获取学生成绩的最大值
            if(maxScore < score){
                maxScore = score;
            }
        }

        //5.遍历Vector，得到每个学生的成绩，并分类
        char level;
        for (int i = 0; i < v.size(); i++) {
            Object obj =v.elementAt(i);
//            Integer integer = (Integer) obj;
//            int score = integer.intValue();

            int score = (Integer) obj;
            if(maxScore - score <= 10){
                level = 'A';
            }else if(maxScore - score <= 20){
                level = 'B';
            }else if(maxScore - score <= 30){
                level = 'C';
            }else{
                level = 'D';
            }
            System.out.println("student-" + (i+1) + "'s score is " + score + ",grade is " + level);
        }

    }
}
