package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Card {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Column(nullable = false)
    private int rarety;

   @ManyToOne
   @JoinColumn(name = "pokemon_id", nullable = false)
    private Pokemon pokemon;

    public Card() {
    }

    public Card(int rarety, Pokemon pokemon) {
        this.rarety = rarety;
        this.pokemon = pokemon;
    }

    public Card(String uuid, int rate, Pokemon pokemon) {
        this.uuid = uuid;
        this.rarety = rate;
        this.pokemon = pokemon;
    }

    public String getUuid() {
        return uuid;
    }

    public int getRarety() {
        return rarety;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
