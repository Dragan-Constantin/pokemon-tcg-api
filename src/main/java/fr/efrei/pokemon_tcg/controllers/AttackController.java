package fr.efrei.pokemon_tcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.dto.AttackDto;
import fr.efrei.pokemon_tcg.models.Attack;
import fr.efrei.pokemon_tcg.services.AttackService;

@RestController
@RequestMapping("/attack")
public class AttackController {
    
    @Autowired
    private AttackService attackService;

    @PostMapping
    public ResponseEntity<?> createAttack(@RequestBody AttackDto attackDto) {
        Attack attack = new Attack(attackDto);

        attackService.add(attack);

        return new ResponseEntity<>(HttpStatus.CREATED);
        
    }
}
