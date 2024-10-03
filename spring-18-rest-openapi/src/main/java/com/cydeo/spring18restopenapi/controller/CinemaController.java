package com.cydeo.spring18restopenapi.controller;

import com.cydeo.spring18restopenapi.entity.Cinema;
import com.cydeo.spring18restopenapi.repository.CinemaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "cinema", description = "Cinema CRUD operations")
public class CinemaController {

    private final CinemaRepository cinemaRepository;

    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping("/cinemas")
    public List<Cinema> readAllCinemas(){
        return cinemaRepository.findAll();
    }

}
