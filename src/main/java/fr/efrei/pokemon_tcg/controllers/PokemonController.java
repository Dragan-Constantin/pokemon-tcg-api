package fr.efrei.pokemon_tcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.dto.PokemonDto;
import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.services.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping
    public ResponseEntity<?> createPokemon(@RequestBody PokemonDto pokemonDto) {
        if (pokemonDto == null) {
            return new ResponseEntity<>("Request body is null", HttpStatus.BAD_REQUEST);
        }

        Pokemon pokemon = pokemonDto.toPokemon();
        pokemonService.add(pokemon);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
