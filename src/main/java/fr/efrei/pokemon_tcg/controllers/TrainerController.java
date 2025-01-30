package fr.efrei.pokemon_tcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import fr.efrei.pokemon_tcg.Dto.TrainerDto;
import fr.efrei.pokemon_tcg.models.Trainer;
import fr.efrei.pokemon_tcg.services.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    
    @Autowired
    private TrainerService trainerService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody TrainerDto trainerDto) {
            final Trainer trainer = trainerService.add(trainerDto);
            return new ResponseEntity<>(trainer, HttpStatus.CREATED);
        
    }
}
