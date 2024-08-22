package com.cydeo.spring15ormqueries.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "departments")
public class Department {

    @Id
    private String department;

    private String division;

}
