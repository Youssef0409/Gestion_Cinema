package com.example.cinema_gestion.Service.Impl;

import com.example.cinema_gestion.Dao.FilmRepository;
import com.example.cinema_gestion.Dao.SalleRepository;
import com.example.cinema_gestion.Models.Film;
import com.example.cinema_gestion.Models.Salle;
import com.example.cinema_gestion.Service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Service
@Slf4j
public class FilmServiceImp implements FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private SalleRepository salleRepository;

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Optional<Film> getFilmById(Long id) {

        return filmRepository.findById(id);
    }

    @Override
    public Film saveFilm(Film film) {
        Long salleId = film.getSalle().getId();
        Salle salle = salleRepository.findById(salleId)
                .orElseThrow(() -> new RuntimeException("Salle not found"));
        film.setNbr_ticket(salle.getNbPlaces());
        film.setSalle(salle);
        return filmRepository.save(film);
    }

    @Override
    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Film> updateFilm(Long filmId, Film filmDetails) {
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new ResourceNotFoundException());

        film.setTitre(filmDetails.getTitre());
        film.setNbr_ticket(filmDetails.getNbr_ticket());
        film.setCreateur(filmDetails.getCreateur());
        film.setGenre(filmDetails.getGenre());
        film.setPrix(filmDetails.getPrix());

        film.setHeureProjection(filmDetails.getHeureProjection());
        film.setDuree(filmDetails.getDuree());
        film.setSalle(filmDetails.getSalle());

        final Film updatedFilm = filmRepository.save(film);
        return ResponseEntity.ok(updatedFilm);

        }
    }









    /*@Override
    public List<Film> searchFilmsByTitle(String title) {
        return filmRepository.findByTitleContainingIgnoreCase(title);*/


