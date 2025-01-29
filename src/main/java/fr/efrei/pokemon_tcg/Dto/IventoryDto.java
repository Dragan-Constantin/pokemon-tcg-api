package fr.efrei.pokemon_tcg.Dto;

import java.util.List;


public class IventoryDto {
    private List<String> cards;

    public IventoryDto() {
    }

    public IventoryDto(List<String> cards) {
        this.cards = cards;
    }

    public List<String> getCards() {
        return cards;
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }
}