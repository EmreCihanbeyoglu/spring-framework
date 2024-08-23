package com.cydeo.spring15ormqueries.bootstrap;

import com.cydeo.spring15ormqueries.repository.DepartmentRepository;
import com.cydeo.spring15ormqueries.repository.EmployeeRepository;
import com.cydeo.spring15ormqueries.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("--------------------- REGION START --------------------");
        System.out.println("region list in Canada" + regionRepository.findByCountry("Canada"));
        System.out.println("unique region list in Canada" + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("region list which is in a country contaning United" + regionRepository.findByCountryContaining("United"));
        System.out.println("region list which is in a country contaning United in order" + regionRepository.findByCountryContainingOrderByCountry("United"));
        System.out.println("top 2 regions from Canada" + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("--------------------- REGION END --------------------");

        System.out.println("--------------------- DEPARTMENT START --------------------");
        System.out.println("department list in Furniture: " + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findbydivision: " + departmentRepository.findByDivision("Health"));
        System.out.println("findbydivisionIs: " + departmentRepository.findByDivisionIs("Health"));
        System.out.println("findByDivisionEquals: " + departmentRepository.findByDivisionEquals("Health"));
        System.out.println("findDistinctTop3ByDivisionContaining: " + departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));
        System.out.println("--------------------- DEPARTMENT END --------------------");

        System.out.println("--------------------- EMPLOYEE START - JPQL --------------------");
        System.out.println("employee detail with email: " + employeeRepository.getEmployeeDetail());
        System.out.println("employee salary: " + employeeRepository.getEmployeeSalary());
        System.out.println("--------------------- EMPLOYEE END --------------------");


    }

}
