package fr.efrei.pokemon_tcg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.pokemon_tcg.dto.trainer.TrainerNameDto;
import fr.efrei.pokemon_tcg.models.Trainer;
import fr.efrei.pokemon_tcg.repositories.TrainerRepository;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private DeckService deckService;

    public Trainer getByUuid(String uuid) {
        return trainerRepository.findByUuid(uuid);
    }

    public Trainer add(TrainerNameDto trainerNameDto) {
        final Trainer trainer = new Trainer(trainerNameDto.getName());
        inventoryService.add(trainer.getInventory());
        deckService.add(trainer.getDeck());


        trainerRepository.save(trainer);
        
        return trainer;
    }
    
}
