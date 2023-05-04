package com.example.cinema_gestion.Dao;

import com.example.cinema_gestion.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
