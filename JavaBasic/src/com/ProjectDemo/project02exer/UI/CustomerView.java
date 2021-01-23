package com.ProjectDemo.project02exer.UI;

import com.ProjectDemo.project02exer.Util.CMUtility;
import com.ProjectDemo.project02exer.bean.Customer;
import com.ProjectDemo.project02exer.service.CustomerList;

public class CustomerView {

    CustomerList customerList = new CustomerList(10);

    public void enterMainMenu(){
        boolean loopFlag = true;
        while(loopFlag){

            System.out.print("-----------------客户信息管理软件-----------------\n");
            System.out.print("                  1.添加客户\n");
            System.out.print("                  2.修改客户\n");
            System.out.print("                  3.删除客户\n");
            System.out.print("                  4.客户列表\n");
            System.out.print("                  5.退   出\n");
            System.out.print("                  请选择（1-5）：");

            char menuSelection = CMUtility.readChar();

            switch(menuSelection){

                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N):");
                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit == 'Y') loopFlag = false;
                    break;
            }


        }
    }

    public void addNewCustomer(){

        System.out.print("---------------------添加客户---------------------\n");

        System.out.print("姓名：");
        String name = CMUtility.readString(10);

        System.out.print("性别：");
        char gender = CMUtility.readChar();

        System.out.print("年龄：");
        int age = CMUtility.readInt();

        System.out.print("电话：");
        String phone = CMUtility.readString(30);

        System.out.print("邮箱：");
        String email = CMUtility.readString(30);

        //将数据封装到对象中
        Customer cust = new Customer(name,gender,age,phone,email);

        boolean isSuccess = customerList.addCustomer(cust);

        if(isSuccess){
            System.out.print("---------------------添加完成---------------------\n");
        }else{
            System.out.print("----------------客户目录已满，添加失败----------------\n");
        }


    }

    public void modifyCustomer(){

        System.out.print("---------------------修改客户---------------------\n");

        Customer cust;
        int index;
        for(;;){
            System.out.print("请输入待修改的客户编号(-1退出)：");

            index = CMUtility.readInt();

            if(index == -1) return;

            cust = customerList.getCustomer(index - 1);//注意-1

            if(cust == null){
                System.out.print("客户编号无效！");
            }else{//找到了对应编号的客户
                break;
            }
        }

        //修改客户的属性
        System.out.print("姓名（" + cust.getName() + "）：");
        String name = CMUtility.readString(10,cust.getName());

        System.out.print("性别（" + cust.getGender() + "）：");
        char gender = CMUtility.readChar(cust.getGender());

        System.out.print("年龄（" + cust.getAge() + "）：");
        int age = CMUtility.readInt(cust.getAge());

        System.out.print("电话（" + cust.getPhone() + "）：");
        String phone = CMUtility.readString(30, cust.getPhone());

        System.out.print("邮箱（" + cust.getEmail() + "）：");
        String email = CMUtility.readString(30, cust.getEmail());

        Customer customer = new Customer(name,gender,age,phone,email);

        boolean isReplaced = customerList.replaceCustomer(index - 1, customer);//注意-1

        if(isReplaced){
            System.out.print("---------------------修改完成---------------------\n");
        }else{
            System.out.print("---------------------修改失败---------------------\n");
        }


    }

    public void deleteCustomer(){

        System.out.print("---------------------删除客户---------------------\n");

        Customer cust;
        int index;
        for(;;){
            System.out.print("请输入待删除的客户编号(-1退出)：");

            index = CMUtility.readInt();

            if(index == -1) return;

            cust = customerList.getCustomer(index - 1);

            if(cust == null){
                System.out.print("客户编号无效！");
            }else{//找到了对应编号的客户
                break;
            }
        }

        System.out.print("确认是否删除(Y/N)：");
        char isConfirmed = CMUtility.readConfirmSelection();

        if(isConfirmed == 'Y'){

            boolean isDeleted = customerList.deleteCustomer(index - 1);

            if(isDeleted){
                System.out.print("---------------------删除完成---------------------\n");
            }else{
                System.out.print("---------------------删除失败---------------------\n");
            }
        }

    }

    public void listAllCustomer(){

        System.out.print("---------------------客户列表---------------------\n");

        int total = customerList.getTotal();

        if(total == 0) {
            System.out.println("无客户记录！");
        }else{
            Customer[] allCusomers = customerList.getAllCustomers();

            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");

            for (int i = 0; i < total; i++) {
                System.out.println((i+1) + "\t" +
                        allCusomers[i].getName() + "\t" +
                        allCusomers[i].getGender() + "\t" +
                        allCusomers[i].getAge() + "\t" +
                        allCusomers[i].getPhone() + "\t" +
                        allCusomers[i].getEmail());
            }
        }

        System.out.print("-------------------------客户列表完成-------------------------\n");



    }

    public static void main(String[] args){

        CustomerView view = new CustomerView();

        view.enterMainMenu();

    }

}
