package com.example.cinema_gestion.Service;

import com.example.cinema_gestion.Models.Cinema;
import com.example.cinema_gestion.Models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface CinemaService {
    List<Cinema> getAllCinemas();
    Optional <Cinema> getCinemaById(Long id);
    Cinema saveCinema(Cinema cinema);
    void deleteCinema(Long id);
    ResponseEntity<Cinema> updateCinema(@PathVariable Long id , @RequestBody Cinema cinema);

}


