package com.example.cinema_gestion.Dao;

import com.example.cinema_gestion.Models.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
