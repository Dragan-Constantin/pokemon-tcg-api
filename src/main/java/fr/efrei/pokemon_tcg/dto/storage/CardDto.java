package fr.efrei.pokemon_tcg.dto.storage;

import fr.efrei.pokemon_tcg.dto.PokemonDto;
import fr.efrei.pokemon_tcg.models.Card;

public class CardDto {
    

    private String uuid;
    private int rarety;
    private PokemonDto pokemon;

    public CardDto() {
    }

    public CardDto(Card card) {
        this.rarety = card.getRarety();
        this.pokemon = new PokemonDto(card.getPokemon());
        this.uuid = card.getUuid();
    }

    public CardDto(int rarety, String uuid, PokemonDto pokemon) {
        this.uuid = uuid;
        this.rarety = rarety;
        this.pokemon = pokemon;
    }

    public int getRarety() {
        return rarety;
    }

    public PokemonDto getPokemon() {
        return pokemon;
    }

    public String getUuid() {
        return uuid;
    }
    
}
