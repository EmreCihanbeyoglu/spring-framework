package com.cydeo.bootstrap;

import com.cydeo.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private final static List<Employee> employeeList = new ArrayList<>();

    public static void saveEmployeeToStore(Employee employee) {
        employeeList.add(employee);
    }

    public static List<Employee> getEmployeeListFromStore() {
        return employeeList;
    }



}
