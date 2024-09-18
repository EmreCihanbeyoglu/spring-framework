package com.cydeo.spring17restconsumingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DummyUser {

    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String picture;

}
