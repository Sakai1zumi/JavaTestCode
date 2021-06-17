package com.th1024.controller;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.th1024.bean.Department;
import com.th1024.bean.Employee;
import com.th1024.dao.DepartmentDao;
import com.th1024.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author TuHong
 * @create 2021-06-15 10:34
 */

@Controller
public class EmpController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工信息用于展示
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "list";
    }

    /**
     * 跳转至添加员工操作，并将部门信息以及表单标签要求的对象存入隐含模型中
     * @param model
     * @return
     */
    @RequestMapping("/toAddEmp")
    public String toAddEmp(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        model.addAttribute("employee",new Employee());
        return "addEmp";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String addEmp(Employee employee){
//        System.out.println("要添加的员工信息为" + employee);
        employeeDao.save(employee);
        //返回列表页面
        return "redirect:/emps";
    }

    /**
     * 根据id获取员工信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String getEmp(@PathVariable("id")Integer id,Model model){
        //1. 根据id查询出员工信息
        Employee employee = employeeDao.get(id);
        //2. 放入隐含模型中
        model.addAttribute("employee",employee);
        //3. 查询出部门信息，放入隐含模型中
        model.addAttribute("departments",departmentDao.getDepartments());
        return "editEmp";
    }

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.PUT)
    public String updateEmp(@ModelAttribute("employee") Employee employee){
//        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 提前获取员工信息并放入隐藏域中
     * @param id
     * @param model
     */
    @ModelAttribute
    public void myModelAttribute(@RequestParam(value = "id",required = false)Integer id, Model model){
        if(id != null){
//            System.out.println(employeeDao.get(id));
            model.addAttribute("employee",employeeDao.get(id));
        }
    }


    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
