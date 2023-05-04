package com.example.cinema_gestion.Controller;

import com.example.cinema_gestion.Controller.Api.FilmApi;
import com.example.cinema_gestion.Models.Film;

import com.example.cinema_gestion.Service.Impl.FilmServiceImp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerFilm implements FilmApi {

    FilmServiceImp filmService;

    public ControllerFilm(FilmServiceImp filmService) {
        this.filmService = filmService;
    }

    @Override
    public Film save(Film film) {
        return filmService.saveFilm(film);
    }

    @Override
    public Optional<Film> findById(Long id) {
        return filmService.getFilmById(id);
    }

    @Override
    public List<Film> findAll() {
        return filmService.getAllFilms();
    }

    @Override
    public void delete(Long id) {
        filmService.deleteFilm(id);

    }

    @Override
    public ResponseEntity<Film> updatefilm(Long id, Film film) {
        return filmService.updateFilm(id,film);
    }
}
