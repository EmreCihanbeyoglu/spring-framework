package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    private String birthDay;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
}
