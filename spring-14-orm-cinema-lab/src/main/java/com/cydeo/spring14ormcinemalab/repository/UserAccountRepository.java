package com.cydeo.spring14ormcinemalab.repository;

import com.cydeo.spring14ormcinemalab.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    Optional<UserAccount> findByEmail(String email);

    //Write a derived query to read a user with a username?
    Optional<UserAccount> findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<UserAccount> findAllByAccountDetails_NameContaining(String pattern);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<UserAccount> findAllByAccountDetails_NameContainingIgnoreCase(String pattern);

    //Write a derived query to list all users with an age greater than a specified age?
    List<UserAccount> findByAccountDetails_AgeGreaterThan(Integer age);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("SELECT u FROM UserAccount u WHERE u.email = ?1")
    Optional<UserAccount> retrieveUserByEmail(String email);

    //Write a JPQL query that returns a user read by username?
    @Query("SELECT u FROM UserAccount u WHERE u.username = ?1")
    Optional<UserAccount> retrieveUserByUsername(String username);

    //Write a JPQL query that returns all users?
    @Query("SELECT u FROM UserAccount u")
    List<UserAccount> retrieveAllUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "SELECT * FROM user_account ua JOIN account_details ad ON ua.account_details_id = ad.id WHERE ad.name ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<UserAccount> fetchAllUsersContainingName(String username);

    //Write a native query that returns all users?
    @Query(value = "SELECT * FROM user_account", nativeQuery = true)
    List<UserAccount> fetchAllUsers();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "SELECT * FROM user_account u JOIN account_details a ON u.account_details_id = a.id WHERE a.age BETWEEN ?1 AND ?2", nativeQuery = true)
    List<UserAccount> fetchAllUsersInTheRange(Integer minAge, Integer maxAge);


    //Write a native query to read a user by email?
    @Query(value = "SELECT * FROM user_account WHERE email = :email",  nativeQuery = true)
    Optional<UserAccount> fetchByEmail(@Param("email") String email);


}
