package fr.efrei.pokemon_tcg.dto.storage;

public class SelectCardDto {

    private int slot;
    
    private String card;

    public SelectCardDto() {
    }

    public SelectCardDto(int slot, String card) {
        this.slot = slot;
        this.card = card;
    }

    public int getSlot() {
        return slot;
    }

    public String getCard() {
        return card;
    }
    
}
