package com.example.test.models;

import javax.persistence.*;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String position;
    private Integer employeeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Position() {
    }

    public Position(String position, Integer employeeId) {
        this.position = position;
        this.employeeId=employeeId;

    }
}
