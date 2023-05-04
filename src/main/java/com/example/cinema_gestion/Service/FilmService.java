package com.example.cinema_gestion.Service;

import com.example.cinema_gestion.Models.Film;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    List<Film> getAllFilms();
    Optional<Film> getFilmById(Long id);
    Film saveFilm(Film film);
    void deleteFilm(Long id);
    ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film film);
   //List<Film> searchFilmsByTitle(String title);
}
