package fr.efrei.pokemon_tcg.models;

import java.util.ArrayList;
import java.util.List;

import fr.efrei.pokemon_tcg.models.enums.PokemonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

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

    @OneToMany
    private List<Attack> attacks;

    public Pokemon() {
        this.attacks = new ArrayList<>();
    }

    public Pokemon(Long id, String name, int hp, PokemonType type, List<Attack> attacks) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.type = type;
        this.attacks = attacks;
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

    public List<Attack> getAttacks() {
        return attacks;
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

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

}
