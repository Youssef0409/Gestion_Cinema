package com.example.cinema_gestion.Dao;

import com.example.cinema_gestion.Models.Ticket;
import com.example.cinema_gestion.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    List<Ticket> findByUser(User user);
}
