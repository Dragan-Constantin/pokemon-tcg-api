package fr.efrei.pokemon_tcg.controllers;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.services.PokemonService;

@RestController
@RequestMapping("/pokemons")
public class PokemonsController {
    
    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/{page}")
    public ResponseEntity<?> getPokemons(@PathVariable int page) {
        Page<Pokemon> pokemons = pokemonService.getPage(page);
        return new ResponseEntity<>(pokemons, HttpStatus.FOUND);
    }
}
