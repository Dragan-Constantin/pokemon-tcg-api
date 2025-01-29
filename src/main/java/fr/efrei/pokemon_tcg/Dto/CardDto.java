package fr.efrei.pokemon_tcg.Dto;

import fr.efrei.pokemon_tcg.models.Card;

public class CardDto {

    private int rarety;
    private PokemonDto pokemon;

    public CardDto() {
    }

    public CardDto(Card card) {
        this.rarety = card.getRarety();
        this.pokemon = new PokemonDto(card.getPokemon());
    }

    public CardDto(int rarety, PokemonDto pokemon) {
        this.rarety = rarety;
        this.pokemon = pokemon;
    }

    public int getRarety() {
        return rarety;
    }

    public PokemonDto getPokemon() {
        return pokemon;
    }
    
}
