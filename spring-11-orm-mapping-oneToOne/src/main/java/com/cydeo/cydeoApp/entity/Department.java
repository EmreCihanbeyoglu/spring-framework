package com.cydeo.cydeoApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department extends BaseEntity{

    private String department;
    private String division;


    @OneToOne(mappedBy = "department")
    private Employee employee;

    public Department(String division, String department) {
        this.division = division;
        this.department = department;
    }
}
