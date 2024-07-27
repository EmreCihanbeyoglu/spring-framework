package com.cydeo.spring12ormmanyrelations.repository;

import com.cydeo.spring12ormmanyrelations.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
