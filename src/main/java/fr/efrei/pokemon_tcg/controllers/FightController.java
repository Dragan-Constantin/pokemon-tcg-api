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
import fr.efrei.pokemon_tcg.models.Attack;
import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.models.Deck;
import fr.efrei.pokemon_tcg.models.Trainer;
import fr.efrei.pokemon_tcg.services.AttackService;
import fr.efrei.pokemon_tcg.services.DeckService;
import fr.efrei.pokemon_tcg.services.TrainerService;

@RestController
@RequestMapping("/fight/{uuid}")
public class FightController {
    
    @Autowired
    private TrainerService trainerService;

    @Autowired
    private AttackService attackService;

    @Autowired
    private DeckService deckService;

    @PostMapping
    public ResponseEntity<?> attack(@PathVariable String uuid, @RequestBody FightDto fightDto) {
        final Trainer trainer = trainerService.getByUuid(uuid);
        
        
        if (trainer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        final Trainer to = trainerService.getByUuid(fightDto.getTo());

        if (to == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        int attackIndex = fightDto.getAttack();
        if (attackIndex < 0 || attackIndex > 1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Deck fromDeck = trainer.getDeck();
        Deck toDeck = to.getDeck();

        Attack attack = fromDeck.getCard(0).getPokemon().getAttack(attackIndex);
        Card card = toDeck.getCard(0);


        card = attackService.fight(attack, card);

        if (card.getHp() <= 0) {
            fromDeck.removeCard(card);
            deckService.save(fromDeck);
        }


        return new ResponseEntity<>(card, HttpStatus.ACCEPTED);
    }
}
