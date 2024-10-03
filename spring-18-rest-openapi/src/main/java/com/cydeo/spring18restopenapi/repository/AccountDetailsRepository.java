package com.cydeo.spring18restopenapi.repository;

import com.cydeo.spring18restopenapi.entity.AccountDetails;
import com.cydeo.spring18restopenapi.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<AccountDetails> findAllByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<AccountDetails> findAllByAgeLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<AccountDetails> findAllByRole(Role role);

    //Write a derived query to list all accounts between a range of ages
    List<AccountDetails> findAllByAgeBetween(Integer minAge, Integer maxAge);


    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<AccountDetails> findByAddressStartsWith(String prefix);


    //Write a derived query to sort the list of accounts with age
    List<AccountDetails> findByOrderByAge();

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT a FROM AccountDetails a")
    List<AccountDetails> findAllAccountsByJPQL();

    //Write a JPQL query to list all admin accounts
    @Query("SELECT a FROM AccountDetails a WHERE a.role = 'ADMIN'")
    List<AccountDetails> findAdminAccountDetailsByJPQL();


    //Write a JPQL query to sort all accounts with age
    @Query("SELECT a FROM AccountDetails a ORDER By a.age")
    List<AccountDetails> findAllAccountDetailsAndSortByAgeByJPQL();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age < ?1", nativeQuery = true)
    List<AccountDetails> readAllAccountDetailsByAgeLessThanBySQL(Integer age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * FROM account_details WHERE name LIKE concat('%', ?1, '%') " +
            "OR address LIKE concat('%', ?1, '%')" +
            "OR country LIKE concat('%', ?1, '%')" +
            "OR state LIKE concat('%', ?1, '%')" +
            "OR city LIKE concat('%', ?1, '%')", nativeQuery = true)
    List<AccountDetails> fetchAllAccountsWithSpecificPatternContainableInNameAddressCountryStateAndCity(String pattern);

    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age > :age", nativeQuery = true)
    List<AccountDetails> readAllAccountDetailsByAgeGreaterThanBySQL(@Param("age")Integer age);

}
