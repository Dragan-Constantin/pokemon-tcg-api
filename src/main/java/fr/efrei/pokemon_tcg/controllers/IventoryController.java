package fr.efrei.pokemon_tcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.Dto.CardDto;
import fr.efrei.pokemon_tcg.Dto.InventoryUuidDto;
import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.services.IventoryService;

@RestController
@RequestMapping("/iventory")
public class IventoryController {
    
    @Autowired
    private IventoryService iventoryService;
    
    @PostMapping("/draw")
    public ResponseEntity<?> drawCard(@RequestBody InventoryUuidDto iventoryUuidDto) {
        final Card card = iventoryService.drawCard(iventoryUuidDto);

        final CardDto cardDto = new CardDto(card);
        return new ResponseEntity<>(cardDto, HttpStatus.OK);
    }
}
