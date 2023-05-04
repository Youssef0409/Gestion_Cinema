package com.example.cinema_gestion.Controller.Api;

import com.example.cinema_gestion.Models.Film;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.cinema_gestion.Utils.Constants.Api_Root;

public interface FilmApi {
    @PostMapping(value =Api_Root+"/film/create")
    Film save(@RequestBody Film film);


    @GetMapping(value = Api_Root+"/film/{id}")
    Optional<Film> findById(@PathVariable("id") Long id);

    @GetMapping(value = Api_Root+"/film/All")
    List<Film> findAll();

    @DeleteMapping(value = Api_Root+"/film/delete/{id}")
    void delete(@PathVariable("id") Long id);

    @PutMapping(value = Api_Root+"/film/{id}")
    ResponseEntity<Film> updatefilm(@PathVariable("id") Long id, @RequestBody Film film);
}

