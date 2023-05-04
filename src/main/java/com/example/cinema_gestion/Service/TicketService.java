package com.example.cinema_gestion.Service;

import com.example.cinema_gestion.Models.Salle;
import com.example.cinema_gestion.Models.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> getAllTickets();
    Optional <Ticket> getTicketById(Long id);
    Ticket saveTicket(Ticket ticket);
    void deleteTicket(Long id);
    ResponseEntity<Ticket> updateTicket(@PathVariable Long id , @RequestBody Ticket ticket);
    //List<Ticket> getTicketsByProjection(Long projectionId);
}
