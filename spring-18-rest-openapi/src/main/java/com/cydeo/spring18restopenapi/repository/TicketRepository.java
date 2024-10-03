package com.cydeo.spring18restopenapi.repository;

import com.cydeo.spring18restopenapi.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countAllByUserAccount_Id(Long userAccountId);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserAccount_Email(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinema_Movie_Name(String name);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime from, LocalDateTime to);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t WHERE t.userAccount.id = ?1")
    List<Ticket> retrieveAllTicketsForUser(Long userAccountId);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> retrieveAllTicketBetweenDates(LocalDateTime from, LocalDateTime to);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "SELECT COUNT(id) FROM ticket WHERE user_account_id = ?1", nativeQuery = true)
    Integer countTicketBoughtByUser(Long id);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT COUNT(id) FROM ticket WHERE user_account_id = ?1 AND date_time BETWEEN ?2 AND ?3", nativeQuery = true)
    Integer countTicketBoughtByUserBetweenDates(Long userId,LocalDateTime from, LocalDateTime to);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT DISTINCT(m.name) FROM ticket t JOIN movie_cinema mc ON t.movie_cinema_id = mc.id " +
            " JOIN movie m ON mc.movie_id = m.id",nativeQuery = true)
    List<String> retrieveAllDistinctMovieName();


    //Write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM ticket t JOIN user_account u ON t.user_account_id = u.id WHERE u.email = ?1", nativeQuery = true)
    List<Ticket> fetchAllUsersByEmail(String email);

    //Write a native query that returns all tickets
    @Query(value = "SELECT * FROM ticket", nativeQuery = true)
    List<Ticket> fetchAllTickets();


    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name
    @Query(value = "SELECT t.* FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id " +
            " JOIN account_details ad ON ua.account_details_id = ad.id JOIN movie_cinema mc " +
            " ON t.movie_cinema_id = mc.id JOIN movie m ON mc.movie_id = m.id " +
            " WHERE ua.username ILIKE concat('%',?1,'%') OR ad.name ILIKE concat('%',?1,'%') OR " +
            " m.name ILIKE concat('%',?1,'%') ",nativeQuery = true)
    List<Ticket> retrieveAllBySearchCriteria(String keyword);

}
