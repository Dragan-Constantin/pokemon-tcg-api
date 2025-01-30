package fr.efrei.pokemon_tcg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.pokemon_tcg.models.Card;
import fr.efrei.pokemon_tcg.models.Inventory;
import fr.efrei.pokemon_tcg.models.Pokemon;
import fr.efrei.pokemon_tcg.repositories.CardRepository;
import fr.efrei.pokemon_tcg.repositories.InventoryRepository;

@Service
public class InventoryService {
    
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private CardRepository cardRepository;

    public Card drawCard(Inventory inventory) {
        List<Pokemon> pokemons = pokemonService.getAll();

        int size = pokemons.size();
        int random = (int) (Math.random() * size);

        final Pokemon pokemon = pokemons.get(random);

        // i want a random (1: 40%, 2: 30%, 3:15%, 4:10%, 5:5%) rarety
        random = (int) (Math.random() * 100) + 1;
        

        int rarety = random;
        if (random <= 40) {
            rarety = 1;
        } else if (rarety <= 70) {
            rarety = 2;
        } else if (rarety <= 85) {
            rarety = 3;
        } else if (rarety <= 95) {
            rarety = 4;
        } else {
            rarety = 5;
        }


        final Card card = new Card(rarety, pokemon);

        cardRepository.save(card);

        //Inventory inventory = inventoryRepository.findByUuid(inventoryUuidDto.getUuid());
        if (inventory == null) {
            inventory = new Inventory();
            inventoryRepository.save(inventory);
        }

        inventory.addCard(card);
        inventoryRepository.save(inventory);

        return card;
    }


    public Inventory getByUuid(String uuid) {
        return inventoryRepository.findByUuid(uuid);
    }


    public void add(Inventory inventory) {
        inventoryRepository.save(inventory);
    }
}
