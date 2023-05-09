package com.example.cinema_gestion.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role ;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Collection<Ticket> ticktes;

    public User(Long id) {
        this.id =id;
    }
    public User(String id) {
        this.id = Long.parseLong(id);
    }
}
