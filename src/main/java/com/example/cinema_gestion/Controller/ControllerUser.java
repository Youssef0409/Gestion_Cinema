package com.example.cinema_gestion.Controller;

import com.example.cinema_gestion.Controller.Api.UserAPI;
import com.example.cinema_gestion.Models.User;
import com.example.cinema_gestion.Service.Impl.UserServiceImp;
import com.example.cinema_gestion.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerUser implements UserAPI {

    UserServiceImp userService;

    public ControllerUser(UserServiceImp userService) {
        this.userService = userService;
    }

    @Override
    public User save(User user) {
        return userService.saveUser(user);
    }

    @Override
    public User findById(Long id) {
        return userService.getUserById(id);
    }

    @Override
    public List<User> findAll() {
        return userService.getAllUsers();
    }

    @Override
    public void delete(Long id) {
         userService.deleteUser(id);

    }

    @Override
    public ResponseEntity<User> updateUser(Long id, User user) {
        return userService.updateUser(id,user);
    }

}
