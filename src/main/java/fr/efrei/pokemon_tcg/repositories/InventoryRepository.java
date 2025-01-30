package fr.efrei.pokemon_tcg.repositories;

import org.springframework.stereotype.Repository;

import fr.efrei.pokemon_tcg.models.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {
    
    public Inventory findByUuid(String uuid);
}
