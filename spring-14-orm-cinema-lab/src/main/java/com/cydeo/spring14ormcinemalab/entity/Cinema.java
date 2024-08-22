package com.cydeo.spring14ormcinemalab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cinema extends BaseEntity {

    private String name;

    private String sponsoredName;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;


}
