package com.cydeo.spring14ormcinemalab.repository;

import com.cydeo.spring14ormcinemalab.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3ByNameContainingOrderBySponsoredName(String name);


    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findByLocation_Country(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findByNameOrSponsoredName(String name, String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("SELECT c.name FROM Cinema c WHERE c.id = ?1")
    Cinema findCinemaByIdByJPQL(String id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "SELECT * FROM cinema c JOIN location l ON c.location_id = l.id WHERE l.country = ?1", nativeQuery = true)
    List<Cinema> findCinemasByLocationCountry(String country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "SELECT * FROM cinema WHERE name ILIKE concat('%', ?1, '%') OR sponsored_name ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<Cinema> findAllCinemasByNameOrSponsoredNameBySQL(String pattern);

    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * FROM cinema ORDER BY name", nativeQuery = true)
    List<Cinema> sortByName();

    //Write a native query to distinct all cinemas by sponsored name ????? not sure if this is correct, I could not understand statement
    @Query(value = "SELECT DISTINCT * FROM cinema WHERE name = ?1", nativeQuery = true)
    List<Cinema> findAllDistinctCinemasByNameBySQL(String name);

}
