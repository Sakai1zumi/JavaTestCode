package com.ProjectDemo.TeamSchedule.domain.equipment;

import com.ProjectDemo.TeamSchedule.domain.equipment.Equipment;

public class PC implements Equipment {

    private String model;//机器型号
    private String display;//显示器名称

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
        return model + "(" + display + ")";
    }
}
