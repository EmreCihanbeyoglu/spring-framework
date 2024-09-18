package com.cydeo.spring16rest.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
public class CourseDTO {

    @JsonIgnore
    private Long id;
    private String name;
    private String category;
    private int rating;
    private String description;

}
