package com.example.cinema_gestion.Service.Impl;

import com.example.cinema_gestion.Dao.CinemaRepository;
import com.example.cinema_gestion.Dao.SalleRepository;
import com.example.cinema_gestion.Models.Cinema;
import com.example.cinema_gestion.Models.Film;
import com.example.cinema_gestion.Models.Salle;
import com.example.cinema_gestion.Service.SalleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class SalleServiceImp implements SalleService {
    @Autowired
private SalleRepository salleRepository;
    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

    @Override
    public Optional <Salle> getSalleById(Long id) {
        return salleRepository.findById(id);

    }

    @Override
    public Salle saveSalle(Salle salle) {
        Cinema cinema = cinemaRepository.findById(salle.getCinema().getId())
                .orElseThrow(() -> new ResourceNotFoundException());
        salle.setCinema(cinema);


        return salleRepository.save(salle);
    }

    @Override
    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Salle> updateSalle(Long salleId, Salle salleDetails) {
        Salle salle = salleRepository.findById(salleId)
                .orElseThrow(() -> new ResourceNotFoundException("Salle not found for this id :: " + salleId));

        salle.setNom(salleDetails.getNom());
        salle.setNbPlaces(salleDetails.getNbPlaces());
        salle.setCinema(salleDetails.getCinema());
        final Salle updatedSalle = salleRepository.save(salle);
        return ResponseEntity.ok(updatedSalle);

    }


}
