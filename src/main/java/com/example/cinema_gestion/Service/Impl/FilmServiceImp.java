package com.example.cinema_gestion.Service.Impl;

import com.example.cinema_gestion.Dao.FilmRepository;
import com.example.cinema_gestion.Dao.SalleRepository;
import com.example.cinema_gestion.Models.Film;
import com.example.cinema_gestion.Models.Salle;
import com.example.cinema_gestion.Service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Film> updateFilm(Long id, Film film) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if (!optionalFilm.isPresent()) {
            return ResponseEntity.notFound().build();}
            Film existingFilm = optionalFilm.get();

            existingFilm.setTitre(film.getTitre());

            existingFilm.setActeur(film.getActeur());

            existingFilm.setGenre(film.getGenre());
            existingFilm.setDuree(film.getDuree());

            existingFilm.setHeureProjection(film.getHeureProjection());


            Film updateFilm = filmRepository.save(existingFilm);




        return ResponseEntity.ok(updateFilm);

        }
    }









    /*@Override
    public List<Film> searchFilmsByTitle(String title) {
        return filmRepository.findByTitleContainingIgnoreCase(title);*/


