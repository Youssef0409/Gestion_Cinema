package com.example.cinema_gestion.Dao;

import com.example.cinema_gestion.Models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
