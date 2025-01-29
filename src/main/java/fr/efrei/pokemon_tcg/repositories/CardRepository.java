package fr.efrei.pokemon_tcg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.efrei.pokemon_tcg.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
    
}
