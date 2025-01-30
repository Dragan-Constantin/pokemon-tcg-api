package fr.efrei.pokemon_tcg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.pokemon_tcg.models.Deck;
import fr.efrei.pokemon_tcg.repositories.DeckRepository;

@Service
public class DeckService {


    @Autowired
    private DeckRepository deckRepository;


    public void add(Deck deck) {
        deckRepository.save(deck);
    }
    
}
