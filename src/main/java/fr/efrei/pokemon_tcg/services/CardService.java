package fr.efrei.pokemon_tcg.services;

import org.springframework.beans.factory.annotation.Autowired;

import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.repositories.CardRepository;

public class CardService {

    @Autowired
    private CardRepository cardRepository;


    public void add(Card card) {
        cardRepository.save(card);
    }
    
}
