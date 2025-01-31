package fr.efrei.pokemon_tcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon_tcg.services.AttackService;

@RestController
@RequestMapping("/attacks")
public class AttacksController {
    
    @Autowired
    private AttackService attackService;


    @GetMapping("{page}")
    public Object getAttacks(@PathVariable int page) {
        return attackService.getPage(page);
    }
}
