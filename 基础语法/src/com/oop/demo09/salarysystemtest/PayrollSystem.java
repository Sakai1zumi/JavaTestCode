package com.oop.demo09.salarysystemtest;

import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem {

    public static void main(String[] args) {

        Employee[] employees = new Employee[2];

        employees[0] = new SalariedEmployee("Tom",0001,new MyDate(1997,3,5),15000);

        employees[1] = new HourlyEmployee("Bob",0002,new MyDate(1993,1,6),100,240);

        //方式一
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("输入当前月份：");
//        int currentMonth = scanner.nextInt();

        //方式二
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;//一月份，MONTH值为0
        System.out.println("当前月份为：" + currentMonth);

        for (int i = 0; i < employees.length; i++) {

            System.out.println(employees[i].toString());

            double salary = employees[i].earnings();
            if(employees[i].getBirthday().getMonth() == currentMonth){
                System.out.print("生日快乐！加薪100，");
                salary += 100;
            }
            System.out.println("月工资为：" + salary);

        }

    }

}
