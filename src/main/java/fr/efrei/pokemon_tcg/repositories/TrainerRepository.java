package fr.efrei.pokemon_tcg.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.efrei.pokemon_tcg.models.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, String> {

    public Trainer findByUuid(String uuid);

    public Page<Trainer> findAll(Pageable pageable);
    
}
