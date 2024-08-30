package com.cydeo.spring14ormcinemalab.bootstrap;

import com.cydeo.spring14ormcinemalab.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataGenerator implements CommandLineRunner {

    private final UserAccountRepository userAccountRepository;
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final TicketRepository ticketRepository;
    private final GenreRepository genreRepository;
    private final AccountDetailsRepository accountDetailsRepository;

    public DataGenerator(UserAccountRepository userAccountRepository, CinemaRepository cinemaRepository, MovieRepository movieRepository, MovieCinemaRepository movieCinemaRepository, TicketRepository ticketRepository, GenreRepository genreRepository, AccountDetailsRepository accountDetailsRepository) {
        this.userAccountRepository = userAccountRepository;
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.ticketRepository = ticketRepository;
        this.genreRepository = genreRepository;
        this.accountDetailsRepository = accountDetailsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(cinemaRepository.findByName("Hall 1 - EMPIRE"));
        System.out.println(accountDetailsRepository.findAdminAccountDetailsByJPQL());
        System.out.println(cinemaRepository.findByLocation_Country("United States"));
        System.out.println(movieRepository.getAllMovieNames());
        System.out.println(movieCinemaRepository.countAllByCinemaId(4L));
        System.out.println(movieCinemaRepository.findAllByCinema_LocationName("AMC Empire 25"));
        System.out.println(ticketRepository.countTicketBoughtByUser(4L));
        System.out.println(ticketRepository.findAllByDateTimeBetween(LocalDateTime.now().minusDays(1000), LocalDateTime.now()));
        System.out.println(ticketRepository.retrieveAllBySearchCriteria("it"));
        System.out.println(genreRepository.findAllBy());
        System.out.println(userAccountRepository.fetchAllUsers());
    }
}
