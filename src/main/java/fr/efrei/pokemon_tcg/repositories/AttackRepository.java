package fr.efrei.pokemon_tcg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.efrei.pokemon_tcg.models.Attack;

@Repository
public interface AttackRepository extends JpaRepository<Attack, String> {


    Attack findByUuid(String uuid);
}
