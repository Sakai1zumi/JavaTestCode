package projectexer.TeamSchedule.domain.equipment;

/**
 * @author TuHong
 * @create 2021-02-24 11:17
 */
public class PC implements Equipment{
    private String model;
    private String display;

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return this.getModel() + "(" + this.getDisplay() + ")";
    }
}
