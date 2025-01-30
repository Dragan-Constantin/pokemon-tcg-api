package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Trainer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    
    @Column(nullable = false)
    private String name;

    @OneToOne
    private Inventory inventory;

    @OneToOne
    private Deck deck;

    public Trainer(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public Trainer(String name, Inventory inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

}
