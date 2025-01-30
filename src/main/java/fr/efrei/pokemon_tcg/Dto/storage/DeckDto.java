package fr.efrei.pokemon_tcg.dto.storage;

import java.util.ArrayList;
import java.util.List;

import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.models.Deck;

public class DeckDto {

    private List<SlotDto> cards;


    public DeckDto() {
    }


    public DeckDto(Deck deck) {
        this.cards = new ArrayList<>();

        final List<Card> cards = deck.getCards();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            CardDto cardDto = new CardDto(card);
            this.cards.add(new SlotDto(i, cardDto));
        }
    }



    public List<SlotDto> getCards() {
        return cards;
    }
    
}