package fr.efrei.pokemon_tcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.dto.storage.CardTransfertDto;
import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.models.Inventory;
import fr.efrei.pokemon_tcg.models.Trainer;
import fr.efrei.pokemon_tcg.services.InventoryService;
import fr.efrei.pokemon_tcg.services.TrainerService;

@RestController
@RequestMapping("/transfert/{uuid}")
public class TransfertController {
    

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<?> transfertCard(@PathVariable String uuid, @RequestBody CardTransfertDto cardTransfertDto) {
        final Trainer from = trainerService.getByUuid(uuid);

        if (from == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        final Trainer to = trainerService.getByUuid(cardTransfertDto.getTo());

        if (to == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        final Inventory inventory = from.getInventory();
        Card card = inventory.findCard(cardTransfertDto.getCard());

        if (card == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        from.getDeck().removeCard(card);
        inventoryService.transfert(inventory, to.getInventory(), card);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
