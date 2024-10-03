package com.cydeo.spring18restopenapi.entity;

import com.cydeo.spring18restopenapi.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountDetails extends BaseEntity {

    private String name;

    private String address;

    private String country;

    private String city;

    private String state;

    private Integer age;

    private String postalCode;

    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public String toString() {
        return "AccountDetails{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", age=" + age +
                ", postalCode='" + postalCode + '\'' +
                ", role=" + role +
                '}';
    }
}
