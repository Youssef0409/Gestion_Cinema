package com.example.cinema_gestion.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Salle {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int nbPlaces;

    @JsonIgnore
    @OneToMany(mappedBy="salle")
    private Collection<Film> films;
    @ManyToOne
    @JoinColumn(name="id_cinema")
    private Cinema cinema;


}
