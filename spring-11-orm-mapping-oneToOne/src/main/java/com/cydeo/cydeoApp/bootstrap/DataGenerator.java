package com.cydeo.cydeoApp.bootstrap;

import com.cydeo.cydeoApp.entity.Department;
import com.cydeo.cydeoApp.entity.Employee;
import com.cydeo.cydeoApp.enums.Gender;
import com.cydeo.cydeoApp.repository.DepartmentRepository;
import com.cydeo.cydeoApp.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner{

    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;

    public DataGenerator(DepartmentRepository departmentService, EmployeeRepository employeeService) {
        this.departmentRepository = departmentService;
        this.employeeRepository = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Department department1 = new Department("IT", "security");
        Department department2 = new Department("Business", "operation");
        Department department3 = new Department("Computers", "electronics");

//        departmentRepository.save(department1);
//        departmentRepository.save(department2);
//        departmentRepository.save(department3);


        Employee employee1 = new Employee("Emre", "Cihan", "emre.cihan@gmail.com", LocalDate.now(), Gender.MALE, 1000L);
        Employee employee2 = new Employee("Yusuf", "Cihan", "yusuf.cihan@gmail.com", LocalDate.now(), Gender.MALE, 2000L);
        Employee employee3 = new Employee("Selim", "Cihan", "selim.cihan@gmail.com", LocalDate.now(), Gender.MALE, 3000L);


        employee1.setDepartment(department1);
        employee2.setDepartment(department2);
        employee3.setDepartment(department3);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);


    }
}
