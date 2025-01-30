package fr.efrei.pokemon_tcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.Dto.CardDto;
import fr.efrei.pokemon_tcg.Dto.TrainerUuidDto;
import fr.efrei.pokemon_tcg.models.Card;
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
    public ResponseEntity<?> drawCard(@RequestBody TrainerUuidDto TrainerUuidDto) {
        final TrainerUuidDto trainerUuidDto = new TrainerUuidDto();

        final Trainer trainer = trainerService.getByUuid(trainerUuidDto.getTrainerUuid());
        final Inventory inventory = trainer.getInventory();

        final Card card = inventoryService.drawCard(inventory);

        final CardDto cardDto = new CardDto(card);
        return new ResponseEntity<>(cardDto, HttpStatus.OK);
    }
}
