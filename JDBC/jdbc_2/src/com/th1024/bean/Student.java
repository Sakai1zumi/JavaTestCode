package com.th1024.bean;

/**
 * @author TuHong
 * @create 2021-03-09 23:04
 */
public class Student {
    private int FlowID;//流水号
    private int Type;//考试类型
    private String IDCard;//身份证号
    private String ExamCard;//准考证号
    private String StudentName;//考生姓名
    private String Location;//所在城市
    private int Grade;//成绩

    public Student() {
    }

    public Student(int flowID, int type, String IDCard, String examCard, String studentName, String location, int grade) {
        FlowID = flowID;
        Type = type;
        this.IDCard = IDCard;
        ExamCard = examCard;
        StudentName = studentName;
        Location = location;
        Grade = grade;
    }

    public int getFlowID() {
        return FlowID;
    }

    public void setFlowID(int flowID) {
        FlowID = flowID;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getExamCard() {
        return ExamCard;
    }

    public void setExamCard(String examCard) {
        ExamCard = examCard;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "流水号：" + FlowID + "\n" +
                "四级/六级：" + Type + "\n" +
                "身份证号：" + IDCard + "\n" +
                "准考证号：" + ExamCard + "\n" +
                "学生姓名：" + StudentName + "\n" +
                "区域：" + Location + "\n" +
                "成绩：" + Grade;
    }
}
