package fr.efrei.pokemon_tcg.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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


    public Pokemon(String uuid, String name, int hp, int rarety) {
        this.uuid = uuid;
        this.name = name;
        this.hp = hp;
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


}
