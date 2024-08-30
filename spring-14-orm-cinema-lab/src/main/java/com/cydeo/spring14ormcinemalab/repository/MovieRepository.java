package com.cydeo.spring14ormcinemalab.repository;

import com.cydeo.spring14ormcinemalab.entity.Movie;
import com.cydeo.spring14ormcinemalab.enums.State;
import com.cydeo.spring14ormcinemalab.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Optional<Movie> findByName(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> findAllByPriceBetween(BigDecimal min, BigDecimal max);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findAllByDurationIn(List<Long> duration);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findAllByReleaseDateAfter(LocalDate releaseDate);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> findAllByStateAndType(State state, Type type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("SELECT m FROM Movie m WHERE m.price BETWEEN ?1 AND ?2")
    List<Movie> retrieveAllByPricesBetween(BigDecimal min, BigDecimal max);

    //Write a JPQL query that returns all movie names
    @Query("SELECT m.name FROM Movie m")
    List<String> getAllMovieNames();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "SELECT * FROM movie WHERE name = ?1", nativeQuery = true)
    Optional<Movie> findMovieByNameBySQL(String name);

    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "SELECT * FROM movie WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Movie> fetchMoviesBetweenPriceRange(BigDecimal from, BigDecimal to);


    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "SELECT * FROM movie WHERE duration IN ?1", nativeQuery = true)
    List<Movie> fetchMoviesDurationInTheRange(List<Integer> durations);

    //Write a native query to list the top 5 most expensive movies
    @Query(value = "SELECT * FROM movie ORDER BY price DESC LIMIT 5", nativeQuery = true)
    List<Movie> fetchTop5MostExpensiveMovies();
}
