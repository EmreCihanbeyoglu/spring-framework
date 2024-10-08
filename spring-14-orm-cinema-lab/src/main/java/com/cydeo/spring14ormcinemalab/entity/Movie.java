package com.cydeo.spring14ormcinemalab.entity;


import com.cydeo.spring14ormcinemalab.enums.State;
import com.cydeo.spring14ormcinemalab.enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie extends BaseEntity  {

    private String name;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    private Long duration;

    private String summary;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel",
    joinColumns = @JoinColumn(name  = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", state=" + state +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", summary='" + summary + '\'' +
                '}';
    }
}
