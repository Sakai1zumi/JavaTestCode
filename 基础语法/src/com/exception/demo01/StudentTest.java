package com.exception.demo01;

public class StudentTest {

    public static void main(String[] args) {

        try {
            Student student = new Student();
            student.regist(-1001);
            System.out.println(student);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

class Student{

    private int id;


    public void regist(int id) throws MyException {

        if(id > 0){
            this.id = id;
        }else{
//            System.out.println("输入非法");
            //手动抛出异常对象
//            throw new RuntimeException("输入数据非法");
//            throw new Exception("输入数据非法");
            throw new MyException("不能输入负数");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
