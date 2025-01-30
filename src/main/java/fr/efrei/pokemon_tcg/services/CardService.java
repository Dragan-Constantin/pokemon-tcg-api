package fr.efrei.pokemon_tcg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.repositories.CardRepository;

@Service
public class CardService {
    

    @Autowired
    private CardRepository cardRepository;

    public void save(Card card) {
        cardRepository.save(card);
    }
}
