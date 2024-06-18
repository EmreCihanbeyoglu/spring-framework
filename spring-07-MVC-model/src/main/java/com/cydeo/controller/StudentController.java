package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model) {

        model.addAttribute("studentName", "Emre");
        model.addAttribute("course", "MVC-model");

        Student student = new Student(1, "Mike", "Smith");
        model.addAttribute("student", student);

        return "/student/welcome";
    }

}
