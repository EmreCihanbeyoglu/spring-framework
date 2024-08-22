package com.cydeo.spring15ormqueries.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity {
    // since in data.sql, we are putting id into insert queries, it seems that
    // id is not generated automatically

    @Id
    private Long id;
}
