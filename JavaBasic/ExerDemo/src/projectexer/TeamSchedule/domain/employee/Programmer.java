package projectexer.TeamSchedule.domain.employee;

import projectexer.TeamSchedule.domain.equipment.Equipment;
import projectexer.TeamSchedule.service.Status;

/**
 * @author TuHong
 * @create 2021-02-24 11:26
 */
public class Programmer extends Employee{
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() +  "\t程序员\t" + getStatus() + "\t\t\t" + getEquipment().getDescription();
    }

    public String getBaseDetails(){
        return memberId + "/" + getId() + '\t' + getName() + '\t' + getAge() + '\t' + getSalary() + '\t';
    }

    public String getDetailsForTeam(){
        return getBaseDetails() + "程序员";
    }
}
