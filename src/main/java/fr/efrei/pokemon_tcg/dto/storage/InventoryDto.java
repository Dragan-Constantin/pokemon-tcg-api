package fr.efrei.pokemon_tcg.dto.storage;

import java.util.List;

import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.models.Inventory;


public class InventoryDto {
    private List<Card> cards;

    public InventoryDto() {
    }

    public InventoryDto(Inventory inventory) {
        this.cards = inventory.getCards();
    }

    public InventoryDto(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}