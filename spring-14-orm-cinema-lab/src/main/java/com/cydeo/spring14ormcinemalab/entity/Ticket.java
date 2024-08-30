package com.cydeo.spring14ormcinemalab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket extends BaseEntity {

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    private Integer seatNumber;

    private Integer rowNumber;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;


    @ManyToOne
    @JoinColumn(name="movie_cinema_id")
    private MovieCinema movieCinema;

    @Override
    public String toString() {
        return "Ticket{" +
                "dateTime=" + dateTime +
                ", seatNumber=" + seatNumber +
                ", rowNumber=" + rowNumber +
                '}';
    }
}
