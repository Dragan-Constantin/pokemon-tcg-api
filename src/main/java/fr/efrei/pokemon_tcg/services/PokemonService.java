package fr.efrei.pokemon_tcg.services;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.repositories.PokemonRepository;

@Service
public class PokemonService {
    
    @Autowired
    private PokemonRepository pokemonRepository;

    public Page<Pokemon> getAll(int page) {
        Pageable pageable = PageRequest.of(page, 10);

        Page<Pokemon> pokemons = pokemonRepository.findAll(pageable);

        return pokemons;
    }


    public void add(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }
}
