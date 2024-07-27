package com.cydeo.spring12ormmanyrelations.repository;

import com.cydeo.spring12ormmanyrelations.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
