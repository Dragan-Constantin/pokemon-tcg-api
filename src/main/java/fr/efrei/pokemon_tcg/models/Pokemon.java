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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int hp;

    @Enumerated(EnumType.STRING)
    private PokemonType type;

    public Pokemon() {
    }

    public Pokemon(Long id, String name, int hp, PokemonType type) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.type = type;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public PokemonType getType() {
        return type;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

}
