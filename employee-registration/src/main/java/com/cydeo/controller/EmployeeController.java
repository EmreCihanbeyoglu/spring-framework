package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.bootstrap.DataStore;
import com.cydeo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("stateList", DataGenerator.getStateList());
        model.addAttribute("employee", new Employee());
        return "/employee/employee-registration";
    }

    @PostMapping("/list")
    public String employeeList(@ModelAttribute("employee") Employee employee, Model model) {
        DataStore.saveEmployeeToStore(employee);
        model.addAttribute("employeeList", DataStore.getEmployeeListFromStore());
        return "/employee/employee-list";
    }
}
