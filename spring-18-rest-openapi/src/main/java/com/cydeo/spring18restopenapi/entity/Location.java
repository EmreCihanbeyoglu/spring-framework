package com.cydeo.spring18restopenapi.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Location extends BaseEntity  {

    private String name;

    private String latitude;

    private String longitude;

    private String country;

    private String city;

    private String state;

    private String postalCode;

    private String address;

}
