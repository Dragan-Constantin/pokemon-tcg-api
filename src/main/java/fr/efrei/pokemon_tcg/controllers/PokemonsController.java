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
    public ResponseEntity<?> getPokemons(@PathVariable String page) {
        try {
            int pageNumber = Integer.parseInt(page);
            if (pageNumber < 0) {
                return new ResponseEntity<>("Page parameter must be a non-negative integer", HttpStatus.BAD_REQUEST);
            }
            Page<Pokemon> pokemons = pokemonService.getPage(pageNumber);
            if (pageNumber >= pokemons.getTotalPages()) {
                return new ResponseEntity<>("Page parameter exceeds the maximum number of pages", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(pokemons, HttpStatus.FOUND);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Page parameter must be an integer", HttpStatus.BAD_REQUEST);
        }
    }
}
