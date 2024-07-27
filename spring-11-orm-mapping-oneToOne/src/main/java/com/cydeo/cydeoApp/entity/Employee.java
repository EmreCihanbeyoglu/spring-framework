package com.cydeo.cydeoApp.entity;

import com.cydeo.cydeoApp.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data
public class Employee extends BaseEntity{



    private String firstName;
    private String lastName;
    private String email;

    @Column(columnDefinition = "Date")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Long salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "region_id")
    private Region region;

    public Employee(String firstName, String lastName, String email, LocalDate hireDate, Gender gender, Long salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
        this.salary = salary;
    }
}
