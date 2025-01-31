package fr.efrei.pokemon_tcg.dto;

import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.models.enums.PokemonType;

public class PokemonDto {
    
    private String name;
    private int hp;
    private PokemonType type;
    private String[] attackUuids;

    public PokemonDto(Pokemon pokemon) {
        this.name = pokemon.getName();
        this.hp = pokemon.getHp();
        this.type = pokemon.getType();
        this.attackUuids = pokemon.getAttacks().stream().map(attack -> attack.getUuid()).toArray(String[]::new);
    }

    public PokemonDto() {
    }

    public PokemonDto(String name, int hp, PokemonType type, String[] attackUuids) {
        this.name = name;
        this.hp = hp;
        this.type = type;
        this.attackUuids = attackUuids;
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

    public String[] getAttackUuids() {
        return attackUuids;
    }
}
