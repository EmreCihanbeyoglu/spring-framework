package com.cydeo.spring12ormmanyrelations.repository;

import com.cydeo.spring12ormmanyrelations.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
