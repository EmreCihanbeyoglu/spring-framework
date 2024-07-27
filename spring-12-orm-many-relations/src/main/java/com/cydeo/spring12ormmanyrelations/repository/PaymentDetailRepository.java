package com.cydeo.spring12ormmanyrelations.repository;

import com.cydeo.spring12ormmanyrelations.entity.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Long> {
}
