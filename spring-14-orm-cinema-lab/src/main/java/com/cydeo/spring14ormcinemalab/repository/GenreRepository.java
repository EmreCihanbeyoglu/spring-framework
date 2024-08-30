package com.cydeo.spring14ormcinemalab.repository;

import com.cydeo.spring14ormcinemalab.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres
    List<Genre> findAllBy();

    @Query("SELECT g FROM Genre g")
    List<Genre> fetchAllGenreByJPQL();

    // ------------------- Native QUERIES ------------------- //
    //Write a native query that returns genres by containing name
    @Query(value = "SELECT * FROM genre WHERE name ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<Genre> retrieveGenreByName(String name);

}
