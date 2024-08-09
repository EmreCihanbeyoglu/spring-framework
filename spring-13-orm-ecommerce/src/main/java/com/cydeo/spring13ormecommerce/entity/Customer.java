package com.cydeo.spring13ormecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends BaseEntity {


    private String firstName;
    private String lastName;
    private String email;
    private String userName;


}
