package com.cydeo.controller;

import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/register")
    public String showMentorForm(Model model) {
        List<String> batchList = Arrays.asList("JD1", "JD2", "JD3", "JD4", "JD5", "JD6");
        model.addAttribute("batchList", batchList);
        model.addAttribute("mentor", new Mentor());
        return "/mentor/mentor-register";
    }

    @PostMapping("/confirm")
    public String confirmMentorForm(@ModelAttribute("mentor") Mentor mentor, Model model) {


        return "/mentor/mentor-confirm";

    }

}
