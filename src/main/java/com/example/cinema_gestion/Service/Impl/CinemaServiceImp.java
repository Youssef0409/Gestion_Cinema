package com.example.cinema_gestion.Service.Impl;

import com.example.cinema_gestion.Dao.CinemaRepository;
import com.example.cinema_gestion.Models.Cinema;
import com.example.cinema_gestion.Models.Film;
import com.example.cinema_gestion.Service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class CinemaServiceImp implements CinemaService {


    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @Override
    public Optional<Cinema> getCinemaById(Long id) {
      return  cinemaRepository.findById(id);

    }

    @Override
    public Cinema saveCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public void deleteCinema(Long id) {
        cinemaRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Cinema> updateCinema(Long id, Cinema cinema) {
            Optional<Cinema> optionalCinema = cinemaRepository.findById(id);
            if (!optionalCinema.isPresent()) {
                return ResponseEntity.notFound().build();}
            Cinema existingCinema = optionalCinema.get();

            existingCinema.setAdress(cinema.getAdress());

            existingCinema.setName(cinema.getName());
            existingCinema.setSalles(cinema.getSalles());




            Cinema updateCinema = cinemaRepository.save(existingCinema);




            return ResponseEntity.ok(updateCinema);

        }    }
