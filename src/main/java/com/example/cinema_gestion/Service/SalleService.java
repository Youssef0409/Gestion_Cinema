package com.example.cinema_gestion.Service;

import com.example.cinema_gestion.Models.Film;
import com.example.cinema_gestion.Models.Salle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface SalleService {
    List<Salle> getAllSalles();
    Optional <Salle>  getSalleById(Long id);
    Salle saveSalle(Salle salle);
    void deleteSalle(Long id);
    ResponseEntity<Salle> updateSalle(@PathVariable Long id, @RequestBody Salle salle);

    // List<Salle> getSallesByCinema(Long cinemaId);

}
