package projectexer.TeamSchedule.service;

import projectexer.TeamSchedule.domain.employee.Architect;
import projectexer.TeamSchedule.domain.employee.Designer;
import projectexer.TeamSchedule.domain.employee.Employee;
import projectexer.TeamSchedule.domain.employee.Programmer;
import projectexer.TeamSchedule.domain.equipment.Equipment;
import projectexer.TeamSchedule.domain.equipment.NoteBook;
import projectexer.TeamSchedule.domain.equipment.PC;
import projectexer.TeamSchedule.domain.equipment.Printer;

import static projectexer.TeamSchedule.service.Data.*;

/**
 * @author TuHong
 * @create 2021-02-24 11:33
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < EMPLOYEES.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;

            switch (type){
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = getEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = getEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT:
                    equipment = getEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }

    private Equipment getEquipment(int i) {
        int key = Integer.parseInt(EQUIPMENTS[i][0]);

        String model;
        String display;
        double price;
        String name;
        String type;

        switch (key){
            case PC:
                model = EQUIPMENTS[i][1];
                display = EQUIPMENTS[i][2];
                return new PC(model,display);
            case NOTEBOOK:
                model = EQUIPMENTS[i][1];
                price = Double.parseDouble(EQUIPMENTS[i][2]);
                return new NoteBook(model,price);
            case PRINTER:
                name = EQUIPMENTS[i][1];
                type = EQUIPMENTS[i][2];
                return new Printer(name,type);
        }
        return null;
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException{
        for (Employee e : employees) {
            if(id == e.getId()){
                return e;
            }
        }
        throw new TeamException("找不到指定员工");
    }
}
