package com.cydeo.CydeoApp.entity;

import com.cydeo.CydeoApp.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentFirstName")
    private String firstName;

    @Column(name = "studentLastName")
    private String lastName;

    @Column(name = "studentEmail")
    private String email;

    // will not be stored in database
    @Transient
    private String city;

    @Column(columnDefinition = "DATE")
    private LocalDate dateOfBirth;

    @Column(columnDefinition = "TIME")
    private LocalTime timeOfBirth;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime lastLogin;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
