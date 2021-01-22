package com.th1024.projecttest;

import com.ProjectDemo.TeamSchedule.domain.employee.Employee;
import com.ProjectDemo.TeamSchedule.service.NameListService;
import com.ProjectDemo.TeamSchedule.service.TeamException;
import org.junit.Test;

/**
 * @Description 对类NameListService的测试
 * @Author TuHong
 * @Date 2021/1/22 16:48
 * @Version 1.0
 */
public class project03 {

    @Test
    public void testGetEmployee() {
        NameListService nameListService = new NameListService();
        int id = 20;
        try {
            Employee employee = nameListService.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void testGetAllEmployees(){

        NameListService nameListService = new NameListService();
        Employee[] allEmployees = nameListService.getAllEmployees();

        for (int i = 0; i < allEmployees.length; i++) {
            System.out.println(allEmployees[i]);
        }

    }
}
