package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mentor {
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    private String batch;
    private boolean graduated;
    private String company;


}
