package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("students", DataGenerator.createStudents());
        return "/student/register";
    }

    @RequestMapping("/welcome")
    public String info() {
        return "student/welcome";
    }



}
