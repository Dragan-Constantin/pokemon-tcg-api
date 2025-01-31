package fr.efrei.pokemon_tcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.dto.storage.DeckDto;
import fr.efrei.pokemon_tcg.dto.storage.InventoryDto;
import fr.efrei.pokemon_tcg.dto.trainer.TrainerUuidDto;
import fr.efrei.pokemon_tcg.models.Deck;
import fr.efrei.pokemon_tcg.models.Inventory;
import fr.efrei.pokemon_tcg.models.Trainer;
import fr.efrei.pokemon_tcg.services.InventoryService;
import fr.efrei.pokemon_tcg.services.TrainerService;

import java.util.Date;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private TrainerService trainerService;


    @GetMapping("/{uuid}")
    public ResponseEntity<?> getInventory(@PathVariable String uuid) {
        final Trainer trainer = trainerService.getByUuid(uuid);

        if (trainer == null) {
            return new ResponseEntity<>("Trainer not found", HttpStatus.NOT_FOUND);
        }

        final Inventory inventory = trainer.getInventory();
        
        final InventoryDto inventoryDto = new InventoryDto(inventory);
        return new ResponseEntity<>(inventoryDto, HttpStatus.OK);
    }
    
    @PostMapping("/draw")
    public ResponseEntity<?> drawCard(@RequestBody TrainerUuidDto trainerUuidDto) {
        final Trainer trainer = trainerService.getByUuid(trainerUuidDto.getTrainer());

        if (trainer == null) {
            return new ResponseEntity<>("Trainer not found", HttpStatus.NOT_FOUND);
        }

        Date now = new Date();
        Date lastDraw = trainer.getLastDraw();

        if (lastDraw != null && now.getTime() - lastDraw.getTime() < 24 * 60 * 60 * 1000) {
            return new ResponseEntity<>("You can only draw once a day", HttpStatus.FORBIDDEN);
        }

        final Inventory inventory = trainer.getInventory();

        final Deck deck = inventoryService.drawCard(inventory);

        trainer.setLastDraw(now);
        trainerService.save(trainer);

        final DeckDto deckDto = new DeckDto(deck);
        return new ResponseEntity<>(deckDto, HttpStatus.OK);
    }

}
