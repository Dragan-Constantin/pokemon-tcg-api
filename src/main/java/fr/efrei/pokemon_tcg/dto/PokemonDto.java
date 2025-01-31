package fr.efrei.pokemon_tcg.dto;

import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.models.enums.PokemonType;

public class PokemonDto {
    
    private String name;
    private int hp;
    private PokemonType type;

    public PokemonDto(Pokemon pokemon) {
        this.name = pokemon.getName();
        this.hp = pokemon.getHp();
        this.type = pokemon.getType();
    }

    public PokemonDto() {
    }

    public PokemonDto(String name, int hp, PokemonType type) {
        this.name = name;
        this.hp = hp;
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }


    public PokemonType getType() {
        return type;
    }

    public Pokemon toPokemon() {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(name);
        pokemon.setHp(hp);
        pokemon.setType(type);

        return pokemon;
    }
}
