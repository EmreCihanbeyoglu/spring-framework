package com.cydeo.spring12ormmanyrelations.repository;

import com.cydeo.spring12ormmanyrelations.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
