package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class Trainer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private Date lastDraw;

    @OneToOne
    private Inventory inventory;

    @OneToOne
    private Deck deck;


    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
        this.inventory = new Inventory();
        this.deck = new Deck();
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

    public Deck getDeck() {
        return deck;
    }

    public Date getLastDraw() {
        return lastDraw;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastDraw(Date lastDraw) {
        this.lastDraw = lastDraw;
    }

}
