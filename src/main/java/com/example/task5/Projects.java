package com.example.task5;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Projects {
    private int id;
    private String projectName;
    private Date startDate;
    private String appointedManger;

    public Projects(int id, String projectName, Date startDate, String appointedManger) {
        this.id = id;
        this.projectName = projectName;
        this.startDate = startDate;
        this.appointedManger = appointedManger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getAppointedManger() {
        return appointedManger;
    }

    public void setAppointedManger(String appointedManger) {
        this.appointedManger = appointedManger;
    }
}
