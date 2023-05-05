package com.example.cinema_gestion.Service.Impl;

import com.example.cinema_gestion.Dao.SalleRepository;
import com.example.cinema_gestion.Models.Film;
import com.example.cinema_gestion.Models.Salle;
import com.example.cinema_gestion.Service.SalleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class SalleServiceImp implements SalleService {
    @Autowired
private SalleRepository salleRepository;

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
        return salleRepository.save(salle);
    }

    @Override
    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Salle> updateSalle(Long id, Salle salle) {
        Optional<Salle> optionalSalle = salleRepository.findById(id);
        if (!optionalSalle.isPresent()) {
            return ResponseEntity.notFound().build();}
        Salle existionSalle = optionalSalle.get();
        existionSalle.setNom(salle.getNom());
        existionSalle.setNbPlaces(salle.getNbPlaces());




        Salle updateSalle = salleRepository.save(existionSalle);
        return ResponseEntity.ok(updateSalle);

    }


}
