package com.example.cinema_gestion.Controller;

import com.example.cinema_gestion.Controller.Api.CinemaApi;

import com.example.cinema_gestion.Models.Cinema;
import com.example.cinema_gestion.Models.Film;
import com.example.cinema_gestion.Service.CinemaService;
import com.example.cinema_gestion.Service.Impl.CinemaServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "*")
public class ControllerCinema implements CinemaApi {

    CinemaServiceImp cinemaService;

    public ControllerCinema(CinemaServiceImp cinemaService) {
        this.cinemaService = cinemaService;
    }

    @Override
    public Cinema save(Cinema cinema) {
        return cinemaService.saveCinema(cinema);
    }

    @Override
    public Optional<Cinema> findById(Long id) {
        return cinemaService.getCinemaById(id);
    }

    @Override
    public List<Cinema> findAll() {
        return cinemaService.getAllCinemas();
    }

    @Override
    public void delete(Long id) {
        cinemaService.deleteCinema(id);

    }

    @Override
    public ResponseEntity<Cinema> updateCinema(Long id, Cinema cinema) {
        return cinemaService.updateCinema(id,cinema);
    }

    public int getNumberOfSallesForCinema( Long cinemaId)
    { return cinemaService.getNumberOfSallesForCinema(cinemaId);}

}
