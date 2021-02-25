package projectexer.TeamSchedule.domain.equipment;

/**
 * @author TuHong
 * @create 2021-02-24 11:20
 */
public class Printer implements Equipment{
    private String name;
    private String type;

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return this.getName() + "(" + this.getType() + ")";
    }
}
