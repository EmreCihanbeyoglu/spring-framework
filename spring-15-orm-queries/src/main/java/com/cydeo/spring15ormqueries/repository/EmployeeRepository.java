package com.cydeo.spring15ormqueries.repository;

import com.cydeo.spring15ormqueries.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // display all employees with email address ""
    List<Employee> findByEmail(String email);

    // display all employees with firstname " " and lastname " ", or show all empployees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);


    // display all employees that firstname is not " "
    List<Employee> findByFirstNameIsNot(String firstName);

    // display all employees where last name starts with
    List<Employee> findByLastNameStartingWith(String lastNamePrefix);

    // display all employees with salaries higher than " "
    List<Employee> findBySalaryGreaterThan(BigDecimal salary);

    // display all employees with salaries less than "" or equal
    List<Employee> findBySalaryLessThanEqual(BigDecimal salary);

    // display all employees with hire date between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // display all employees where salaries greater and equal to "" in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(BigDecimal salary);

    // display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(BigDecimal salary);

    // display all employees that don not have email
    List<Employee> findByEmailIsNull();

}
