package com.example.cinema_gestion.Service;

import com.example.cinema_gestion.Models.AuthentificationRequest;
import com.example.cinema_gestion.Models.RegisterRequest;
import com.example.cinema_gestion.Models.User;

public interface AuthentificationService {
    User register(RegisterRequest request);
    User authenticate(AuthentificationRequest request);
}
