package fr.efrei.pokemon_tcg.models.enums;

public enum PokemonType {
    FIRE,
    WATER,
    PLANT,
    ELECTRIC,
    PSYCHIC,
    FIGHTING,
    NORMAL,
    FAIRY,
    DRAGON,
    STEEL,
    GROUND,
    ROCK,
    ICE,
    BUG,
    POISON,
    GHOST,
    DARK,
    FLYING;


    @Override
    public String toString() {
        return name();
    }
}
