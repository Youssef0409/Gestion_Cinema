package com.example.cinema_gestion.Service;

import com.example.cinema_gestion.Models.Ticket;
import com.example.cinema_gestion.Models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    ResponseEntity<User> updateUser(@PathVariable Long id , @RequestBody User user);

}

