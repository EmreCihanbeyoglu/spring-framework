package com.cydeo.spring12ormmanyrelations.entity;

import com.cydeo.spring12ormmanyrelations.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "payments")
public class Payment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private BigDecimal amount;

    @Column(columnDefinition = "Date")
    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_detail_id")
    private PaymentDetail paymentDetail;

    public Payment(BigDecimal amount, LocalDate createdDate, Status paymentStatus) {
        this.amount = amount;
        this.createdDate = createdDate;
        this.paymentStatus = paymentStatus;
    }

    @ManyToOne
    private Merchant merchant;

    @ManyToOne
    private Customer customer;

}
