package fr.efrei.pokemon_tcg.repositories;

import org.springframework.stereotype.Repository;

import fr.efrei.pokemon_tcg.models.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IventoryRepository extends JpaRepository<Inventory, String> {
    
    public Inventory findByUuid(String uuid);
}
