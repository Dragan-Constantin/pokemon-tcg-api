package fr.efrei.pokemon_tcg.Dto;

import java.util.List;
import java.util.stream.Collectors;

import fr.efrei.pokemon_tcg.models.Inventory;


public class InventoryDto {
    private List<CardDto> cards;

    public InventoryDto() {
    }

    public InventoryDto(Inventory inventory) {
        this.cards = inventory.getCards().stream()
            .map(card -> new CardDto(card))
            .collect(Collectors.toList());
    }

    public InventoryDto(List<CardDto> cards) {
        this.cards = cards;
    }

    public List<CardDto> getCards() {
        return cards;
    }

    public void setCards(List<CardDto> cards) {
        this.cards = cards;
    }
}