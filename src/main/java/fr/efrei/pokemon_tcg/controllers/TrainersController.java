package fr.efrei.pokemon_tcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.models.Trainer;
import fr.efrei.pokemon_tcg.services.TrainerService;

@RestController
@RequestMapping("/trainers")
public class TrainersController {
    
    @Autowired
    private TrainerService trainerService;

    @GetMapping("/{page}")
    public ResponseEntity<?> getTrainers(@PathVariable int page) {
        Page<Trainer> trainers = trainerService.getByPage(page);
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }
}
