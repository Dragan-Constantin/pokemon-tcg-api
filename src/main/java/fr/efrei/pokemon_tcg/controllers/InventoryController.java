package fr.efrei.pokemon_tcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.Dto.CardDto;
import fr.efrei.pokemon_tcg.Dto.DeckDto;
import fr.efrei.pokemon_tcg.Dto.TrainerUuidDto;
import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.models.Deck;
import fr.efrei.pokemon_tcg.models.Inventory;
import fr.efrei.pokemon_tcg.models.Trainer;
import fr.efrei.pokemon_tcg.services.InventoryService;
import fr.efrei.pokemon_tcg.services.TrainerService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private TrainerService trainerService;
    
    @PostMapping("/draw")
    public ResponseEntity<?> drawCard(@RequestBody TrainerUuidDto trainerUuidDto) {
        final Trainer trainer = trainerService.getByUuid(trainerUuidDto.getTrainer());

        if (trainer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        final Inventory inventory = trainer.getInventory();

        final Deck deck = inventoryService.drawCard(inventory);

        final DeckDto deckDto = new DeckDto(deck);
        return new ResponseEntity<>(deckDto, HttpStatus.OK);
    }
}
