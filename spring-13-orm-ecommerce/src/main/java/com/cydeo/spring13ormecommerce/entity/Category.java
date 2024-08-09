package com.cydeo.spring13ormecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseEntity{

    private String name;


    @ManyToMany(mappedBy = "categoryList")
    private List<Product> productList;
}
