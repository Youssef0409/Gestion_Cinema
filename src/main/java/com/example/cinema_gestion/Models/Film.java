package com.example.cinema_gestion.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long id;
    private String titre;
    private int nbr_ticket;
    private String acteur;
    private String genre;

    @Temporal(TemporalType.TIMESTAMP)
    private Date heureProjection;
    private String Duree;


    @ManyToOne
    @JoinColumn(name="id_salle")
    private Salle salle;
    @JsonIgnore
    @OneToMany(mappedBy="film")
    private Collection<Ticket> tickets;



    public boolean isNbrTicketAvailable() {
        return nbr_ticket > 0;
    }

    public void decrementNbrTicket() {
        nbr_ticket--;
    }

}
