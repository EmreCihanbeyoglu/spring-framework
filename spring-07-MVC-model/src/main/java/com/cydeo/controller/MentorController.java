package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/mentors")
    public String printMentorsInTable(Model model) {

        List<Mentor> mentorList = new ArrayList<Mentor>();
        mentorList.add(new Mentor("Emre", "Cihan", 35, Gender.MALE));
        mentorList.add(new Mentor("Ali", "Cihan", 3, Gender.MALE));
        mentorList.add(new Mentor("Mehmet", "Cihan", 5, Gender.MALE));
        mentorList.add(new Mentor("Sumeyye", "Cihan", 34, Gender.FEMALE));
        mentorList.add(new Mentor("Ahmet", "Cihan", 38, Gender.MALE));

        model.addAttribute("mentors", mentorList);
        return "/mentor/mentors";
    }

}
