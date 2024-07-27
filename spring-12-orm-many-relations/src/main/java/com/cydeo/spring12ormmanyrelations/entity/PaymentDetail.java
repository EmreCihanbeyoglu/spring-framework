package com.cydeo.spring12ormmanyrelations.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "payment_details")
public class PaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "payment_detail_id")
    private Long paymentDetailId;

    private BigDecimal commissionAmount;
    private BigDecimal merchantPayoutAmount;

    @Column(columnDefinition = "Date")
    private LocalDate payoutDate;

    @OneToOne(mappedBy = "paymentDetail")
    private Payment payment;

    public PaymentDetail(BigDecimal commissionAmount, BigDecimal merchantPayoutAmount, LocalDate payoutDate) {
        this.commissionAmount = commissionAmount;
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.payoutDate = payoutDate;

    }
}
