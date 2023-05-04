package com.example.cinema_gestion.Service.Impl;

import com.example.cinema_gestion.Dao.UserRepository;
import com.example.cinema_gestion.Models.AuthentificationRequest;
import com.example.cinema_gestion.Models.RegisterRequest;
import com.example.cinema_gestion.Models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthentificationServiceImp {

    private final UserRepository repository;
    public User register(RegisterRequest request) {
        var user = User.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .password((request.getPassword()))
                .role(request.getRole())
                .build();
        var savedUser = repository.save(user);
        return savedUser;
    }

    public User authenticate(AuthentificationRequest request) {
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(); // throws exception if email is not found
        if (user.getPassword().equals(request.getPassword())) {
            return user;
        } else {
            throw new RuntimeException("Incorrect email or password");
        }
    }

}
