package fr.efrei.pokemon_tcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.dto.storage.DeckDto;
import fr.efrei.pokemon_tcg.dto.storage.SelectCardDto;
import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.models.Deck;
import fr.efrei.pokemon_tcg.models.Inventory;
import fr.efrei.pokemon_tcg.models.Trainer;
import fr.efrei.pokemon_tcg.services.DeckService;
import fr.efrei.pokemon_tcg.services.TrainerService;

@RestController
@RequestMapping("/deck/{uuid}")
public class DeckController {


    @Autowired
    private TrainerService trainerService;
    
    @Autowired
    private DeckService deckService;
    
    @PutMapping
    public ResponseEntity<?> addCardToDeck(@RequestBody SelectCardDto slotDto, @PathVariable String uuid) {
        final Trainer trainer = trainerService.getByUuid(uuid);

        if (trainer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        final Inventory inventory = trainer.getInventory();
        Card card = inventory.findCard(slotDto.getCard());

        if (card == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        final Deck deck = trainer.getDeck();

        deck.setSlot(slotDto.getSlot(), card);
        deckService.save(deck);
        

        final DeckDto deckDto = new DeckDto(deck);
        return new ResponseEntity<>(deckDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getDeck(@PathVariable String uuid) {
        final Trainer trainer = trainerService.getByUuid(uuid);

        if (trainer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        final Deck deck = trainer.getDeck();

        final DeckDto deckDto = new DeckDto(deck);
        return new ResponseEntity<>(deckDto, HttpStatus.OK);
    }
}
