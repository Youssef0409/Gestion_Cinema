package com.example.cinema_gestion.Controller;

import com.example.cinema_gestion.Controller.Api.SalleApi;
import com.example.cinema_gestion.Models.Salle;
import com.example.cinema_gestion.Service.Impl.SalleServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerSalle implements SalleApi {
    SalleServiceImp salleServiceImp;

    public ControllerSalle(SalleServiceImp salleServiceImp) {
        this.salleServiceImp = salleServiceImp;
    }

    @Override
    public Salle save(Salle salle) {
        return salleServiceImp.saveSalle(salle);
    }

    @Override
    public Optional<Salle> findById(Long id) {
        return salleServiceImp.getSalleById(id);
    }

    @Override
    public List<Salle> findAll() {
        return salleServiceImp.getAllSalles();
    }

    @Override
    public void delete(Long id) {salleServiceImp.deleteSalle(id);

    }

    @Override
    public ResponseEntity<Salle> updateSalle(Long id, Salle salle) {
        return  salleServiceImp.updateSalle(id,salle);
    }
}
