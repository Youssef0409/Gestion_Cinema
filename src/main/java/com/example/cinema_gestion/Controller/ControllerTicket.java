package com.example.cinema_gestion.Controller;

import com.example.cinema_gestion.Controller.Api.TicketApi;
import com.example.cinema_gestion.Models.Film;
import com.example.cinema_gestion.Models.Ticket;
import com.example.cinema_gestion.Service.Impl.TickerServiceImp;
import com.example.cinema_gestion.Service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerTicket implements TicketApi {

    TickerServiceImp tickerServiceImp;

    public ControllerTicket(TickerServiceImp tickerServiceImp) {
        this.tickerServiceImp = tickerServiceImp;
    }

    @Override
    public Ticket save(Ticket ticket) {
        return tickerServiceImp.saveTicket(ticket);
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return tickerServiceImp.getTicketById(id);
    }

    @Override
    public List<Ticket> findAll() {
        return tickerServiceImp.getAllTickets();
    }

    @Override
    public void delete(Long id) { tickerServiceImp.deleteTicket(id);

    }

    @Override
    public ResponseEntity<Ticket> updateTicket(Long id, Ticket ticket) {
        return tickerServiceImp.updateTicket(id,ticket);
    }

    public List<Ticket> getTicketsByUser(Long userId) {

        return tickerServiceImp.getTicketsByUser(userId);
    }

    public int getNumberOfTicketsForUser(Long userId) {
        return tickerServiceImp.getNumberOfTicketsForUser(userId);
    }
}
