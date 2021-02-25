package projectexer.TeamSchedule.domain.employee;

import projectexer.TeamSchedule.domain.equipment.Equipment;

/**
 * @author TuHong
 * @create 2021-02-24 11:31
 */
public class Architect extends Designer{
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + '\t' + getBonus() + '\t' + getStock() + '\t' + getEquipment().getDescription();
    }

    public String getDetailsForTeam(){
        return getBaseDetails() + "架构师\t" + getBonus() + '\t' + getStock();
    }
}
