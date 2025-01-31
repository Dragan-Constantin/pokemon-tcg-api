package fr.efrei.pokemon_tcg.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.dto.PokemonDto;
import fr.efrei.pokemon_tcg.models.Attack;
import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.services.AttackService;
import fr.efrei.pokemon_tcg.services.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private AttackService attackService;

    @PostMapping
    public ResponseEntity<?> createPokemon(@RequestBody PokemonDto pokemonDto) {
        if (pokemonDto == null) {
            return new ResponseEntity<>("Request body is null", HttpStatus.BAD_REQUEST);
        }

        if (pokemonDto.getAttackUuids().length > 2) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

        List<Attack> attacks = new ArrayList<>();

        if (pokemonDto.getAttackUuids() != null) {
            for (String attackUuid : pokemonDto.getAttackUuids()) {
                Attack attack = attackService.getAttack(attackUuid);

                if (attack == null) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

                }
                attacks.add(attack);
            }
        }
    
}
