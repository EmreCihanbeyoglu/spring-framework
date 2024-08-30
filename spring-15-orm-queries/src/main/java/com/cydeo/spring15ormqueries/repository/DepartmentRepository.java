package com.cydeo.spring15ormqueries.repository;

import com.cydeo.spring15ormqueries.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // display all departments with its name
    List<Department> findByDepartment(String departmentName);


    // display all departments in the health division
    List<Department> findByDivisionIs(String divisionIs);
    List<Department> findByDivisionEquals(String division);
    List<Department> findByDivision(String division);


    // display top3 departments with division name includes "Hea", without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String divisionPrefix);


    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> getDepartmentsByDivisionList(List<String> divisionList);

    List<Department> retrieveDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);

}
