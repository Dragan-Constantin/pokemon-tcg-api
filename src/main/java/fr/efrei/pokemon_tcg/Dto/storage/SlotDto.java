package fr.efrei.pokemon_tcg.dto.storage;

public class SlotDto {


    private int slot;
    private CardDto card;

    public SlotDto() {
    }

    public SlotDto(int slot, CardDto card) {
        this.slot = slot;
        this.card = card;
    }

    public int getSlot() {
        return slot;
    }

    public CardDto getCard() {
        return card;
    }
    
}
