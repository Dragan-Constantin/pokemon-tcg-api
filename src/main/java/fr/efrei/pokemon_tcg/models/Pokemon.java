package fr.efrei.pokemon_tcg.models;

import fr.efrei.pokemon_tcg.models.enums.PokemonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pokemon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int hp;

    @Column(nullable = false)
    private int rarety;

    @Enumerated(EnumType.STRING)
    private PokemonType type;

    public Pokemon() {
    }

    public Pokemon(String uuid, String name, int hp, PokemonType type, int rarety) {
        this.uuid = uuid;
        this.name = name;
        this.hp = hp;
        this.type = type;
        this.rarety = rarety;
    }


    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getRarety() {
        return rarety;
    }

    public PokemonType getType() {
        return type;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setRarety(int rarety) {
        this.rarety = rarety;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

}
