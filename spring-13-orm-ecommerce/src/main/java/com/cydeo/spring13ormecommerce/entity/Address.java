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
public class Address extends BaseEntity{


    private String name;
    private String street;
    private String zipCode;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
}
