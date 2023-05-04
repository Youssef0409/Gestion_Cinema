package com.example.cinema_gestion.Controller.Api;

import com.example.cinema_gestion.Models.Film;
import com.example.cinema_gestion.Models.Salle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.cinema_gestion.Utils.Constants.Api_Root;

public interface SalleApi {
    @PostMapping(value = Api_Root + "/salle/create")
    Salle save(@RequestBody Salle salle);
    @GetMapping(value = Api_Root + "/salle/{id}")
    Optional<Salle> findById(@PathVariable("id") Long id);
    @GetMapping(value = Api_Root + "/salle/All")
    List<Salle> findAll();
    @DeleteMapping(value = Api_Root + "/salle/delete/{id}")
    void delete(Long id);
    @PutMapping(value = Api_Root+"/salle/{id}")
    ResponseEntity<Salle> updateSalle(@PathVariable("id") Long id, @RequestBody Salle salle);
}
