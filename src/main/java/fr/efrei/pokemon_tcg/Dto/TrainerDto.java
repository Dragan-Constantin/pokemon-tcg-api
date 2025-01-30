package fr.efrei.pokemon_tcg.Dto;

import fr.efrei.pokemon_tcg.models.Trainer;

public class TrainerDto {


    private String uuid;
    private String name;
    private InventoryDto inventory;
    private DeckDto deck;


    public TrainerDto() {
    }

    public TrainerDto(Trainer trainer) {
        this.uuid = trainer.getUuid();
        this.name = trainer.getName();
        this.inventory = new InventoryDto(trainer.getInventory());
        this.deck = new DeckDto(trainer.getDeck());
    }


    public DeckDto getDeck() {
        return deck;
    }

    public InventoryDto getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }
    
}
