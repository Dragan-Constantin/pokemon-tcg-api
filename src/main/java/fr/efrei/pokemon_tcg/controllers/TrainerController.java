package fr.efrei.pokemon_tcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import fr.efrei.pokemon_tcg.Dto.TrainerDto;
import fr.efrei.pokemon_tcg.Dto.TrainerNameDto;
import fr.efrei.pokemon_tcg.models.Trainer;
import fr.efrei.pokemon_tcg.services.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    
    @Autowired
    private TrainerService trainerService;



    @GetMapping("{uuid}")
    public ResponseEntity<?> get(@PathVariable String uuid) {
        final Trainer trainer = trainerService.getByUuid(uuid);

        if (trainer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        final TrainerDto trainerDto = new TrainerDto(trainer);

        return new ResponseEntity<>(trainerDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody TrainerNameDto trainerNameDto) {
            final Trainer trainer = trainerService.add(trainerNameDto);

            final TrainerDto trainerDto = new TrainerDto(trainer);
            return new ResponseEntity<>(trainerDto, HttpStatus.CREATED); 
    }
}
