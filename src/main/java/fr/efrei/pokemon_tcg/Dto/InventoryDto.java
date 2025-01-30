package fr.efrei.pokemon_tcg.Dto;

import java.util.List;


public class InventoryDto {
    private List<String> cards;

    public InventoryDto() {
    }

    public InventoryDto(List<String> cards) {
        this.cards = cards;
    }

    public List<String> getCards() {
        return cards;
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }
}