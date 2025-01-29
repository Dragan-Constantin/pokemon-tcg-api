package fr.efrei.pokemon_tcg.Dto;

import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.models.enums.PokemonType;

public class PokemonDto {
    
    private String name;
    private int hp;
    private int rarety;
    private PokemonType type;


    public PokemonDto(String name, int hp, PokemonType type, int rarety) {
        this.name = name;
        this.hp = hp;
        this.type = type;
        this.rarety = rarety;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public int getRarety() {
        return rarety;
    }

    public PokemonType getType() {
        return type;
    }

    public Pokemon toPokemon() {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(name);
        pokemon.setHp(hp);
        pokemon.setType(type);
        pokemon.setRarety(rarety);

        return pokemon;
    }
}
