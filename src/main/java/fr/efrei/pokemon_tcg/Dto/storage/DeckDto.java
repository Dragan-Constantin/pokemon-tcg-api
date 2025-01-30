package fr.efrei.pokemon_tcg.dto.storage;

import java.util.List;
import java.util.stream.Collectors;

import fr.efrei.pokemon_tcg.models.Deck;

public class DeckDto {

    public List<CardDto> cards;


    public DeckDto() {
    }


    public DeckDto(Deck deck) {
        this.cards = deck.getCards().stream()
            .map(card -> new CardDto(card))
            .collect(Collectors.toList());
    }

    public List<CardDto> getCards() {
        return cards;
    }
}