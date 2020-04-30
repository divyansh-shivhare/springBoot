package com.persistent.pip.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;


//@Component

// Spring jpa jars.
@Entity
@Table(name= "project")

// To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate

public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int projecctId;
    private String projectName;
    private String projectType;
    private String projectManager;
    private String client;
    private Date toDate;
    private Date fromDate;

    public Project() {
    }

    public int getProjecctId() {
        return projecctId;
    }

    public void setProjecctId(int projecctId) {
        this.projecctId = projecctId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projecctId=" + projecctId +
                ", projectName='" + projectName + '\'' +
                ", projectType='" + projectType + '\'' +
                ", projectManager='" + projectManager + '\'' +
                ", client='" + client + '\'' +
                ", toDate=" + toDate +
                ", fromDate=" + fromDate +
                '}';
    }
}
