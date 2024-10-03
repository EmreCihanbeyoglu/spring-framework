package com.cydeo.spring18restopenapi.repository;

import com.cydeo.spring18restopenapi.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Integer> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> findById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countAllByCinemaId(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countAllByMovieId(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByDateTimeAfter(LocalDateTime dateTime);


    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findTop3ByOrderByMovie_PriceDesc();


    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findAllByMovie_NameContaining(String name);

    //Write a derived query to list all movie cinemas in a specific location
    List<MovieCinema> findAllByCinema_LocationName(String locationName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("SELECT mc FROM MovieCinema mc WHERE mc.dateTime > ?1")
    List<MovieCinema> retrieveAllWithDateAfter(LocalDateTime dateTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "SELECT COUNT(id) FROM movie_cinema WHERE cinema_id = ?1 ", nativeQuery = true)
    Integer countByCinemaId(Long id);

    //Write a native query that returns all movie cinemas by location name
    @Query(value = "SELECT mc.* FROM movie_cinema mc " +
            "JOIN cinema c ON mc.cinema_id = c.id " +
            "JOIN location l ON c.location_id = l.id " +
            "WHERE l.name = ?1", nativeQuery = true)
    List<MovieCinema> retrieveAllMovieCinemasByLocationName(String locationName);
}
