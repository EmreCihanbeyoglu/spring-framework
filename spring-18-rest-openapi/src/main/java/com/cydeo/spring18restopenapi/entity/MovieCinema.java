package com.cydeo.spring18restopenapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MovieCinema extends BaseEntity {

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Cinema cinema;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @Override
    public String toString() {
        return "MovieCinema{" +
                "dateTime=" + dateTime +
                '}';
    }
}
