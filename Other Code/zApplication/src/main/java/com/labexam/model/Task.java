package com.labexam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class Task {
    private int id;
    private String description;
    private String status;
    private Date dueDate;


    public Task(String description, String status, Date dueDate) {
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }
}
