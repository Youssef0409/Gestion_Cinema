package com.example.cinema_gestion.Service.Impl;

import com.example.cinema_gestion.Dao.FilmRepository;
import com.example.cinema_gestion.Dao.TicketRepository;
import com.example.cinema_gestion.Models.Film;
import com.example.cinema_gestion.Models.Ticket;
import com.example.cinema_gestion.Models.User;
import com.example.cinema_gestion.Service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class TickerServiceImp implements TicketService {
    @Autowired
private TicketRepository ticketRepository;
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional <Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);

    }

    public List<Ticket> getTicketsByUser(Long userId) {
        User user = new User(userId);
        return ticketRepository.findByUser(user);
    }

    @Override
    public Ticket saveTicket(Ticket ticket){
        Long filmId = ticket.getFilm().getId();
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new RuntimeException("Film not found"));
        ticket.setFilm(film);
        if (film.isNbrTicketAvailable()) {
            double prixTicket = film.getPrix();
            ticket.setPrix(prixTicket);
            film.decrementNbrTicket();
            filmRepository.save(film);
            return ticketRepository.save(ticket);
        } else {
            throw new RuntimeException("No more tickets available for this film");
        }
    }


    public ResponseEntity<Ticket> updateTicket(Long id, Ticket ticket) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (!optionalTicket.isPresent()) {
            return ResponseEntity.notFound().build();}
        Ticket existingTicket = optionalTicket.get();


        existingTicket.setPrix(ticket.getPrix());


        Ticket updateTicket = ticketRepository.save(existingTicket);




        return ResponseEntity.ok(updateTicket);

    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }


}
