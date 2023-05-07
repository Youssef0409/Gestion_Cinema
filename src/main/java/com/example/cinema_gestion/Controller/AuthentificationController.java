package com.example.cinema_gestion.Controller;

import com.example.cinema_gestion.Models.AuthentificationRequest;
import com.example.cinema_gestion.Models.RegisterRequest;
import com.example.cinema_gestion.Models.User;
import com.example.cinema_gestion.Service.AuthentificationService;
import com.example.cinema_gestion.Service.Impl.AuthentificationServiceImp;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.cinema_gestion.Utils.Constants.Api_Root;

@RestController
@CrossOrigin(origins = "*")
public class AuthentificationController  {

    private final AuthentificationServiceImp authService;

    public AuthentificationController(AuthentificationServiceImp authService) {
        this.authService = authService;
    }

    @PostMapping(value=Api_Root+"/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterRequest request) {
        User user = authService.register(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping(value = Api_Root+"/login")
    public ResponseEntity<User> loginUser(@RequestBody AuthentificationRequest request) {
        User user = authService.authenticate(request);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
