package fr.efrei.pokemon_tcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.dto.FightDto;
import fr.efrei.pokemon_tcg.models.Trainer;
import fr.efrei.pokemon_tcg.services.TrainerService;

@RestController
@RequestMapping("/attack/{uuid}")
public class FightController {
    
    @Autowired
    private TrainerService trainerService;

    @PostMapping
    public ResponseEntity<?> attack(@PathVariable String uuid,@RequestBody FightDto fightDto) {
        final Trainer trainer = trainerService.getByUuid(uuid);
        
        
        if (trainer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        final Trainer to = trainerService.getByUuid(fightDto.getTo());

        if (to == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // find attack


        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
