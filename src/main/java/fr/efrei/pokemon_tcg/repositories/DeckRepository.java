package fr.efrei.pokemon_tcg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.efrei.pokemon_tcg.models.Deck;

@Repository
public interface DeckRepository extends JpaRepository<Deck, String> {
    
}
